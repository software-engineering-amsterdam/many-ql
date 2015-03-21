namespace QL.AST.Nodes.Branches.Operators
{
    public class MinusOperator : BinaryTreeElementBase, IOperator, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }
    }
}