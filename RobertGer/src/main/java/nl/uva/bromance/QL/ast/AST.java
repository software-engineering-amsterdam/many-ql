package nl.uva.bromance.QL.ast;


public class AST<NODETYPE extends Node<NODETYPE>>
{
    private final NODETYPE root;

    public AST(NODETYPE root)
    {
        this.root = root;
    }

    public NODETYPE getRoot()
    {
        return root;
    }
}