namespace QL.AST.Nodes.Branches.Operators
{
    public class PlusOperator : BinaryTreeElementBase, IReturnTypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }

        public PlusOperator(SourceLocation sourceLocation)
        {
            SourceLocation = sourceLocation;
        }
    }
}