namespace QL.AST.Nodes.Branches.Operators
{
    public class MultiplicationOperator : BinaryTreeElementBase, IInferredReturnType
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }

        public MultiplicationOperator(SourceLocation sourceLocation)
        {
            this.SourceLocation = sourceLocation;
        }
    }
}