namespace QL.AST.Nodes.Branches.Operators
{
    public class MinusOperator : BinaryTreeElementBase, IInferredReturnType
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }

        public MinusOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}