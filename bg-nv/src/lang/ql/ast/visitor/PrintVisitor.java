package lang.ql.ast.visitor;

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
            statement.visit(this);
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
        n.getExpression().visit(this);
        this.builder.append(" {");

        for(Statement statement : n.getStatements())
        {
            statement.visit(this);
        }
        this.builder.append("} ");
    }

    @Override
    public void visit(Expression n)
    {

    }

    @Override
    public void visit(BooleanExpression n)
    {

    }

    @Override
    public void visit(IntegerExpression n)
    {

    }

    @Override
    public void visit(DecimalExpression n)
    {

    }

    @Override
    public void visit(StringExpression n)
    {

    }

    @Override
    public void visit(AdditionExpression n)
    {

    }

    @Override
    public void visit(SubtractionExpression n)
    {

    }

    @Override
    public void visit(GreaterThanExpression n)
    {

    }

    @Override
    public void visit(UnaryMinusExpression n)
    {

    }

    @Override
    public void visit(UnaryPlusExpression n)
    {

    }

    @Override
    public void visit(VariableExpression n)
    {

    }

    public String getString()
    {
        return this.builder.toString();
    }
}
