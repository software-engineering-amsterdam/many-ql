namespace QL.AST.Nodes.Branches.Operators
{
    public class MultiplicationOperator : BinaryTreeElementBase, IOperator, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }
    }
}