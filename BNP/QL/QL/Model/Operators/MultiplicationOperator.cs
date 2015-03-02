using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class MultiplicationOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }
        public override Type GetReturnType()
        {
            return Left.GetReturnType();
        }
    }
}