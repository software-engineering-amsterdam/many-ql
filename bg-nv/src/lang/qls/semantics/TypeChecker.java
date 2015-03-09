package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.type.*;
import lang.ql.semantics.errors.Message;
import lang.qls.ast.Page;
import lang.qls.ast.Rule.*;
import lang.qls.ast.Statement.*;
import lang.qls.ast.Statement.Question;
import lang.qls.ast.Statement.Statement;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;
import lang.qls.semantics.messages.StyleError;

import java.util.*;

/**
 * Created by bore on 03/03/15.
 */
public class TypeChecker implements StylesheetVisitor<Boolean>, StatementVisitor<Boolean>
{
    private QuestTypes qlQuestions;
    private Set<String> refQuestions;
    private List<Message> messages;

    public static List<Message> check(Stylesheet s, Form f)
    {
        QuestTypes qs = QLQuestionVisitor.extractQuestions(f);
        TypeChecker checker = new TypeChecker(qs);
        checker.visit(s);

        checker.allQuestionsReferencedCheck();

        return checker.messages;
    }

    private TypeChecker(QuestTypes qlQuestions)
    {
        this.qlQuestions = qlQuestions;
        this.refQuestions = new HashSet<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public Boolean visit(Stylesheet s)
    {
        for (Page p : s.getBody())
        {
            Boolean r = p.accept(this);
            if (!(r))
            {
                return r;
            }
        }

        return true;
    }

    @Override
    public Boolean visit(Page p)
    {
        for (Statement s : p.getBody())
        {
            Boolean r = s.accept(this);
            if (!(r))
            {
                return r;
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
            Type qType = this.qlQuestions.getType(q.getId());
            return this.visitRules(rs, qType, q.getLineNumber());
        }

        return false;
    }

    private Boolean registerQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.qlQuestions.containsQuestion(id)))
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
        for (String id : this.qlQuestions)
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
