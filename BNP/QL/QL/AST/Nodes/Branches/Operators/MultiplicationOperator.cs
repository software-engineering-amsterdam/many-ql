namespace QL.AST.Nodes.Branches.Operators
{
    public class MultiplicationOperator : BinaryTreeElementBase, IReturnTypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }

        public MultiplicationOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}