package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;
import lang.ql.ast.type.*;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolVisitor implements Visitor
{
    private SymbolTable symbolTable;

    public SymbolVisitor()
    {
        this.symbolTable = new SymbolTable();
    }

    public SymbolTable getSymbolTable()
    {
        return this.symbolTable;
    }

    @Override
    public void visit(Form form)
    {
        for (Statement statement : form.getStatements())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(IfCondition condition)
    {
        for (Statement statement : condition.getStatements())
        {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Question n)
    {
        this.symbolTable.define(n, n.getType());
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        this.symbolTable.define(n, n.getType());
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
