namespace QL.AST.Nodes
{
    public interface IInferredReturnType : IResolvable
    {
        ElementBase GetTypeInferableChild();
    }
}
