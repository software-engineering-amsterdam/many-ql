using AST.ASTVisitors;

namespace AST.Nodes.Interfaces
{
    public interface IVisitable
    {
        T Accept<T>(IVisitor<T> visitor);
    }
}
