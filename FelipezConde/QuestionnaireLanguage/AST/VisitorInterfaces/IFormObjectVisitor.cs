using AST.Nodes.FormObjects;

namespace AST.VisitorInterfaces
{
    public interface IFormObjectVisitor<T>
    {
        T Visit(Conditional conditional);
        T Visit(Question question);

    }
}
