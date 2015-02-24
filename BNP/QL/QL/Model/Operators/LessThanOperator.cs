using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class LessThanOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}