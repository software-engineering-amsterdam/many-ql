namespace QL.AST.Nodes.Branches.Operators
{
    public class PlusOperator : BinaryTreeElementBase, IOperator, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }
    }
}