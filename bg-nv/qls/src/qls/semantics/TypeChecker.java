package qls.semantics;

import ql.ast.form.Form;
import ql.ast.type.*;
import ql.semantics.QuestionCollector;
import ql.semantics.Questions;
import ql.semantics.errors.Messages;
import qls.ast.Page;
import qls.ast.rule.*;
import qls.ast.statement.*;
import qls.ast.Stylesheet;
import qls.ast.StylesheetVisitor;
import qls.ast.statement.Question;
import qls.ast.statement.Statement;
import qls.semantics.messages.StyleError;

import java.util.*;

/**
 * Created by bore on 03/03/15.
 */
public class TypeChecker implements StylesheetVisitor<Void>, StatementVisitor<Void>
{
    private final Questions questions;
    private final Set<String> refQuestions;
    private final Messages messages;

    public static Messages check(Stylesheet s, Form f)
    {
        Questions questions = QuestionCollector.collect(f);

        TypeChecker checker = new TypeChecker(questions);
        s.accept(checker);
        checker.allQuestionsReferencedCheck();

        return checker.messages;
    }

    private TypeChecker(Questions questions)
    {
        this.questions = questions;
        this.refQuestions = new HashSet<>();
        this.messages = new Messages();
    }

    @Override
    public Void visit(Stylesheet s)
    {
        for (Page p : s.getBody())
        {
            p.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Page p)
    {
        for (Statement s : p.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Section s)
    {
        for (Statement stat : s.getBody())
        {
            stat.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.addQuestionReference(q);
        return null;
    }

    @Override
    public Void visit(QuestionWithRules q)
    {
        this.addQuestionReference(q);

        if (this.questions.contains(q.getId()))
        {
            Rules rs = q.getBody();
            Type qType = this.questions.getType(q.getId());
            this.checkForWidgetTypeMismatch(rs, qType, q.getLineNumber());
        }

        return null;
    }

    @Override
    public Void visit(DefaultStat d)
    {
        Rules rs = d.getBody();
        Type type = d.getType();
        this.checkForWidgetTypeMismatch(rs, type, d.getLineNumber());

        return null;
    }

    private void addQuestionReference(Question q)
    {
        String id = q.getId();
        if (this.isQuestionNotDefinedInForm(q))
        {
            this.messages.add(StyleError.undefinedQuestion(id, q.getLineNumber()));
        }

        if (this.isQuestionAlreadyReferenced(q))
        {
            this.messages.add(StyleError.questionAlreadyReferenced(id, q.getLineNumber()));
        }

        this.refQuestions.add(id);
    }

    private void checkForWidgetTypeMismatch(Rules rs, Type declType, Integer lineNumber)
    {
        for (Rule r : rs)
        {
            if (!(r.isCompatibleWithType(declType)))
            {
                this.messages.add(StyleError.widgetTypeMismatch(declType.getTitle(), lineNumber));
            }
        }
    }

    private boolean isQuestionNotDefinedInForm(Question q)
    {
        return !(this.questions.contains(q.getId()));
    }

    private boolean isQuestionAlreadyReferenced(Question q)
    {
        return this.refQuestions.contains(q.getId());
    }

    private void allQuestionsReferencedCheck()
    {
        for (String id : this.questions)
        {
            if (this.isQuestionNotReferenced(id))
            {
                this.messages.add(StyleError.questionNotReferenced(id));
            }
        }
    }

    private boolean isQuestionNotReferenced(String id)
    {
        return !(this.refQuestions.contains(id));
    }
}
