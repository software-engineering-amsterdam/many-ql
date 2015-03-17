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
public class TypeChecker implements StylesheetVisitor<Boolean>, StatementVisitor<Boolean>
{
    private final Questions questions;
    private final Set<String> refQuestions;
    private final Messages messages;

    public static Messages check(Stylesheet s, Form f)
    {
        Questions questions = QuestionCollector.collect(f);

        TypeChecker checker = new TypeChecker(questions);
        if (checker.visit(s))
        {
            checker.allQuestionsReferencedCheck();
        }

        return checker.messages;
    }

    private TypeChecker(Questions questions)
    {
        this.questions = questions;
        this.refQuestions = new HashSet<>();
        this.messages = new Messages();
    }

    @Override
    public Boolean visit(Stylesheet s)
    {
        for (Page p : s.getBody())
        {
            if (!(p.accept(this)))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Page p)
    {
        for (Statement s : p.getBody())
        {
            if (!(s.accept(this)))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Section s)
    {
        for (Statement stat : s.getBody())
        {
            if (!(stat.accept(this)))
            {
                return false;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Question q)
    {
        return this.registerQuestion(q);
    }

    @Override
    public Boolean visit(QuestionWithRules q)
    {
        if (this.registerQuestion(q))
        {
            Rules rs = q.getBody();
            Type qType = this.questions.getType(q.getId());

            return this.visitRules(rs, qType, q.getLineNumber());
        }

        return false;
    }

    private Boolean registerQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.questions.contains(id)))
        {
            this.messages.add(StyleError.undefinedQuestion(id, q.getLineNumber()));
            return false;
        }

        if (this.refQuestions.contains(id))
        {
            this.messages.add(StyleError.questionAlreadyReferenced(id, q.getLineNumber()));
            return false;
        }

        this.refQuestions.add(id);

        return true;
    }

    @Override
    public Boolean visit(DefaultStat d)
    {
        Rules rs = d.getBody();
        return this.visitRules(rs, d.getType(), d.getLineNumber());
    }

    private Boolean visitRules(Rules rs, Type declType, int lineNumber)
    {
        for (Rule r : rs)
        {
            if (r.isCompatibleWithType(declType))
            {
                this.messages.add(StyleError.widgetTypeMismatch(declType.getTitle(), lineNumber));
                return false;
            }
        }

        return true;
    }

    private Boolean allQuestionsReferencedCheck()
    {
        for (String id : this.questions)
        {
            if (!(this.refQuestions.contains(id)))
            {
                this.messages.add(StyleError.questionNotReferenced(id));
                return false;
            }
        }

        return true;
    }
}
