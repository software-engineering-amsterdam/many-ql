using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class OrOperator : BinaryTreeElementBase, IOperator, ITypeStatic
    {
        public Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}