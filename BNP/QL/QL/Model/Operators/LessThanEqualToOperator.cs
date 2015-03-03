﻿using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class LessThanEqualToOperator : BinaryTreeElementBase, IOperator<BinaryTreeElementBase, BinaryTreeElementBase>, ITypeResolvable
    {
        public ITerminalType Evaluate()
        {
            throw new NotImplementedException();
        }

        public override Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}