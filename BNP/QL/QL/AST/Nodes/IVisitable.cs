namespace QL.AST.Nodes
{

    public interface IVisitable
    {
        void Accept(IVisitor visitor);

    }
}
