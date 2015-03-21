using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class MinusOperator : BinaryTreeElementBase, IOperator, ITypeInferred
    {
        public ElementBase GetTypeInferableChild()
        {
            return Left;
        }
    }
}