using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class LessThanOperator : BinaryTreeElementBase, IOperator, ITypeResolvableDirectly
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}