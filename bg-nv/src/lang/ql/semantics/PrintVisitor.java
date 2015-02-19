package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.Statement;

/**
 * Created by bore on 14/02/15.
 */
public class PrintVisitor implements Visitor
{
    private StringBuilder builder;

    public PrintVisitor()
    {
        this.builder = new StringBuilder();
    }

    private void printChildren()
    {}

    @Override
    public void visit(Form n)
    {
        this.builder.append(n.getClass().getSimpleName());
        this.builder.append(" id=");
        this.builder.append(n.getId());
        this.builder.append(" {");

        for(Statement statement : n.getStatements())
        {
            statement.accept(this);
        }

        this.builder.append("}");
    }

    @Override
    public void visit(Question n)
    {
        this.builder.append(n.getClass().getSimpleName());
        this.builder.append(" id=");
        this.builder.append(n.getId());
        this.builder.append(" type=");
        this.builder.append(n.getQuestionType());
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        this.visit((Question)n);
        this.builder.append(" expression");
    }

    @Override
    public void visit(IfCondition n)
    {
        this.builder.append(n.getClass().getSimpleName());
        this.builder.append(" condition=");
        n.getExpr().accept(this);
        this.builder.append(" {");

        for(Statement statement : n.getStatements())
        {
            statement.accept(this);
        }
        this.builder.append("} ");
    }

    @Override
    public void visit(BoolExpr n)
    {

    }

    @Override
    public void visit(IntExpr n)
    {

    }

    @Override
    public void visit(DecExpr n)
    {

    }

    @Override
    public void visit(StrExpr n)
    {

    }

    @Override
    public void visit(Add n)
    {

    }

    @Override
    public void visit(Sub n)
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
    public void visit(Gt n)
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

    @Override
    public void visit(Neg n)
    {

    }

    @Override
    public void visit(Pos n)
    {

    }

    @Override
    public void visit(Not e)
    {

    }

    @Override
    public void visit(Identifier n)
    {

    }

    public String getString()
    {
        return this.builder.toString();
    }
}
