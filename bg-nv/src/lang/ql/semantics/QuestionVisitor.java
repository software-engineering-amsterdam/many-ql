package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.Statement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bore on 23/02/15.
 */
public class QuestionVisitor implements Visitor<Void>
{
    private Map<String, Question> idToQuestion;

    public static Map<String, Question> getQuestions(Form f)
    {
        QuestionVisitor visitor = new QuestionVisitor();
        f.accept(visitor);

        return visitor.idToQuestion;
    }

    private QuestionVisitor()
    {
        this.idToQuestion = new HashMap<String, Question>();
    }

    @Override
    public Void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition condition)
    {
        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.idToQuestion.put(q.getId(), q);

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.idToQuestion.put(q.getId(), q);

        return null;
    }

    @Override
    public Void visit(BoolExpr e)
    {
        return null;
    }

    @Override
    public Void visit(IntExpr e)
    {
        return null;
    }

    @Override
    public Void visit(DecExpr e)
    {
        return null;
    }

    @Override
    public Void visit(StrExpr e)
    {
        return null;
    }

    @Override
    public Void visit(Ident e)
    {
        return null;
    }

    @Override
    public Void visit(Neg e)
    {
        return null;
    }

    @Override
    public Void visit(Pos e)
    {
        return null;
    }

    @Override
    public Void visit(Not e)
    {
        return null;
    }

    @Override
    public Void visit(Add e)
    {
        return null;
    }

    @Override
    public Void visit(Sub e)
    {
        return null;
    }

    @Override
    public Void visit(Mul e)
    {
        return null;
    }

    @Override
    public Void visit(Div e)
    {
        return null;
    }

    @Override
    public Void visit(Gt e)
    {
        return null;
    }

    @Override
    public Void visit(Lt e)
    {
        return null;
    }

    @Override
    public Void visit(GtEqu e)
    {
        return null;
    }

    @Override
    public Void visit(LtEqu e)
    {
        return null;
    }

    @Override
    public Void visit(Equ e)
    {
        return null;
    }

    @Override
    public Void visit(NotEqu e)
    {
        return null;
    }

    @Override
    public Void visit(And e)
    {
        return null;
    }

    @Override
    public Void visit(Or e)
    {
        return null;
    }
}
