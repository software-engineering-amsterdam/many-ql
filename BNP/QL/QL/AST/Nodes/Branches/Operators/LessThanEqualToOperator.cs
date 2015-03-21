using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class LessThanEqualToOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}