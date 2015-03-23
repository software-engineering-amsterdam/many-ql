namespace QL.AST.Nodes
{
    public interface IReturnTypeInferred : IResolvable
    {
        ElementBase GetTypeInferableChild();
    }
}
