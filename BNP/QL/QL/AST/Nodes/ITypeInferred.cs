namespace QL.AST.Nodes
{
    public interface ITypeInferred : ITypeResolvable
    {
        ElementBase GetTypeInferableChild();
    }
}
