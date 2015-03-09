using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class MultiplicationOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>, ITypeResolvableByChildren
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }

        
    }
}