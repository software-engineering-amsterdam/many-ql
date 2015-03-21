using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class OrOperator : BinaryTreeElementBase, IOperator, IStaticReturnType
    {
        public Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }
    }
}