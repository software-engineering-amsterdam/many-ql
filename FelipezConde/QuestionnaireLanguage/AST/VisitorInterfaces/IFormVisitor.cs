using AST.Nodes;

namespace AST.VisitorInterfaces
{
    public interface IFormVisitor<T>
    {
        T Visit(Form node);
    }
}
