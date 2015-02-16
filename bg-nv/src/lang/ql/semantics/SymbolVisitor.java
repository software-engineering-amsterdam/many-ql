package lang.ql.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.statement.*;

/**
 * Created by bore on 13/02/15.
 */
public class SymbolVisitor extends VisitorAbstract
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
        this.symbolTable.define(n.getId(), n.getQuestionType());
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        this.symbolTable.define(n.getId(), n.getQuestionType());
    }
}
