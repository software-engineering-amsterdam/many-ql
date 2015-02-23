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
public class QuestionVisitor implements Visitor
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
    public void visit(Form form)
    {
        for (Statement statement : form.getBody())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfCondition condition)
    {
        for (Statement statement : condition.getBody())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Question q)
    {
        this.idToQuestion.put(q.getId(), q);
    }

    @Override
    public void visit(CalculatedQuestion q)
    {
        this.idToQuestion.put(q.getId(), q);
    }

    @Override
    public void visit(BoolExpr e)
    {

    }

    @Override
    public void visit(IntExpr e)
    {

    }

    @Override
    public void visit(DecExpr e)
    {

    }

    @Override
    public void visit(StrExpr e)
    {

    }

    @Override
    public void visit(Indent e)
    {

    }

    @Override
    public void visit(Neg e)
    {

    }

    @Override
    public void visit(Pos e)
    {

    }

    @Override
    public void visit(Not e)
    {

    }

    @Override
    public void visit(Add e)
    {

    }

    @Override
    public void visit(Sub e)
    {

    }

    @Override
    public void visit(Mul e)
    {

    }

    @Override
    public void visit(Div e)
    {

    }

    @Override
    public void visit(Gt e)
    {

    }

    @Override
    public void visit(Lt e)
    {

    }

    @Override
    public void visit(GtEqu e)
    {

    }

    @Override
    public void visit(LtEqu e)
    {

    }

    @Override
    public void visit(Equ e)
    {

    }

    @Override
    public void visit(NotEqu e)
    {

    }

    @Override
    public void visit(And e)
    {

    }

    @Override
    public void visit(Or e)
    {

    }
}
