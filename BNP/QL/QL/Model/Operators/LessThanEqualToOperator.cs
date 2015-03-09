using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class LessThanEqualToOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>, ITypeResolvableDirectly
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}