using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class GreaterThanOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}