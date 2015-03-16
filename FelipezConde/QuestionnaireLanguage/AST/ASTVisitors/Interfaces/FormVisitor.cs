using AST.Nodes;

namespace AST.ASTVisitors.Interfaces
{
    public interface FormVisitor<T>
    {
        T Visit(Form node);

    }
}
