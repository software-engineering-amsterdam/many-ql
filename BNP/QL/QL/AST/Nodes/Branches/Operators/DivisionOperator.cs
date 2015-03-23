namespace QL.AST.Nodes.Branches.Operators
{
    public class DivisionOperator : BinaryTreeElementBase, IReturnTypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }


        public DivisionOperator(SourceLocation sourceLocation)
        {
            this.SourceLocation = sourceLocation;
        }
    }
}