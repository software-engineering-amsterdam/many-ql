using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class AndOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}