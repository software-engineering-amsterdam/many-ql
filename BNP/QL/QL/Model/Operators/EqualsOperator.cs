using System;
using QL.Model.Terminals;
using QL.Exceptions;

namespace QL.Model.Operators
{
    public class EqualsOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }

        public override Type GetReturnType()
        {
            return (new Yesno()).GetType();
        }
    }
}