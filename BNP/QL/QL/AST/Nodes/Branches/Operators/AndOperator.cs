using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class AndOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}