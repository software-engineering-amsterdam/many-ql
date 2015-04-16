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
            this.SourceLocation = sourceLocation;
        }
    }
}