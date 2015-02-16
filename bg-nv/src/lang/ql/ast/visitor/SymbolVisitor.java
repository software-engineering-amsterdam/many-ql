package lang.ql.ast.visitor;

import lang.ql.ast.AstNode;
import lang.ql.ast.SymbolTable;
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

    public SymbolTable visit(AstNode node)
    {
        this.visitInternal(node);
        return this.symbolTable;
    }

    private void visitInternal(AstNode node)
    {
        node.visit(this);

        for (AstNode child : node.getChildren())
        {
            this.visitInternal(child);
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
