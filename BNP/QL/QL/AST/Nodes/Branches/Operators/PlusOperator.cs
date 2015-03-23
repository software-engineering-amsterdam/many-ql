namespace QL.AST.Nodes.Branches.Operators
{
    public class PlusOperator : BinaryTreeElementBase, ITypeInferred
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