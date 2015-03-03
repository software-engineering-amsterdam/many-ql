package lang.qls.semantics;

import lang.ql.ast.form.Form;
import lang.ql.semantics.errors.Message;
import lang.qls.ast.Page;
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
    private Map<String, lang.ql.ast.statement.Question> questionMap;
    private Set<String> referredQuestions;
    private List<Message> messages;

    public static List<Message> check(Stylesheet s, Form f)
    {
        Map<String, lang.ql.ast.statement.Question> m = QLQuestionVisitor.extractQuestions(f);
        TypeChecker checker = new TypeChecker(m);
        checker.visit(s);

        checker.allQuestionsReferencedCheck();

        return checker.messages;
    }

    private TypeChecker(Map<String, lang.ql.ast.statement.Question> questionMap)
    {
        this.questionMap = questionMap;
        this.referredQuestions = new HashSet<String>();
        this.messages = new ArrayList<Message>();
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
        return this.registerQuestion(q);
    }

    private Boolean registerQuestion(Question q)
    {
        String id = q.getId();
        if (!(this.questionMap.containsKey(id)))
        {
            this.messages.add(StyleError.undefinedQuestion(id, q.getLineNumber()));
            return false;
        }

        if (this.referredQuestions.contains(id))
        {
            this.messages.add(StyleError.questionAlreadyReferenced(id, q.getLineNumber()));
            return false;
        }

        this.referredQuestions.add(id);

        return true;
    }

    @Override
    public Boolean visit(DefaultStmt d)
    {
        return true;
    }

    private Boolean allQuestionsReferencedCheck()
    {
        for (lang.ql.ast.statement.Question q : this.questionMap.values())
        {
            String id = q.getId();
            if (!(this.referredQuestions.contains(id)))
            {
                this.messages.add(StyleError.questionNotReferenced(id));
                return false;
            }
        }
        return true;
    }
}
