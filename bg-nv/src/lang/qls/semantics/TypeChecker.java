package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.type.*;
import lang.ql.semantics.QuestionCollector;
import lang.ql.semantics.QuestionResult;
import lang.ql.semantics.QuestionMap;
import lang.ql.semantics.errors.Messages;
import lang.qls.ast.Page;
import lang.qls.ast.rule.*;
import lang.qls.ast.statement.*;
import lang.qls.ast.statement.Question;
import lang.qls.ast.statement.Statement;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;
import lang.qls.semantics.messages.StyleError;

import java.util.*;

/**
 * Created by bore on 03/03/15.
 */
public class TypeChecker implements StylesheetVisitor<Boolean>, StatementVisitor<Boolean>
{
    private QuestionMap questions;
    private Set<String> refQuestions;
    private Messages messages;

    public static Messages check(Stylesheet s, Form f)
    {
        QuestionResult result = QuestionCollector.collect(f);
        if (result.containsErrors())
        {
            return result.getMessages();
        }

        TypeChecker checker = new TypeChecker(result.getQuestionMap());
        if (checker.visit(s))
        {
            checker.allQuestionsReferencedCheck();
        }

        return checker.messages;
    }

    private TypeChecker(QuestionMap questions)
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
