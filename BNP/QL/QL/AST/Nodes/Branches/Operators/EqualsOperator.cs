using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class EqualsOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}