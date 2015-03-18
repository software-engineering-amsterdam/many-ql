using System;
using QL.Model.Terminals;

namespace QL.Model.Operators
{
    public class LessThanEqualToOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}