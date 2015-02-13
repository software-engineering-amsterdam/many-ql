package lang.ql.ast.visitor;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expression;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.ast.symboltable.Symbol;
import lang.ql.ast.symboltable.SymbolTable;
import lang.ql.ast.symboltable.VariableSymbol;

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

    public SymbolTable visit(AstNode node)
    {
        this.visitInternal(node);
        return this.symbolTable;
    }

    private void visitInternal(AstNode node)
    {
        node.visit(this);
        // TODO: use IEnumerable
        if (node.getChildren() != null)
        {
            for (AstNode child : node.getChildren())
            {
                this.visitInternal(child);
            }
        }
    }

    @Override
    public void visit(Form n)
    {

    }

    @Override
    public void visit(Question n)
    {
        Symbol s = new VariableSymbol(n.getId(), n.getQuestionType());
        this.symbolTable.define(s);
    }

    @Override
    public void visit(IfCondition n)
    {

    }

    @Override
    public void visit(Expression n)
    {

    }
}
