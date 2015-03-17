using AST.Nodes;

namespace AST.ASTVisitors.Interfaces
{
    public interface IFormVisitor<T>
    {
        T Visit(Form node);
    }
}
