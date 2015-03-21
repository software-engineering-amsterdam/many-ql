namespace QL.AST.Nodes.Branches.Operators
{
    public class DivisionOperator : BinaryTreeElementBase, IOperator, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }
        
    }
}