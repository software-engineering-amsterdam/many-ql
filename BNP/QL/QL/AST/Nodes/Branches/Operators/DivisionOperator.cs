namespace QL.AST.Nodes.Branches.Operators
{
    public class DivisionOperator : BinaryTreeElementBase, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }


        public DivisionOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}