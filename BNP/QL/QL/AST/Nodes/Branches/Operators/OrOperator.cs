using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class OrOperator : BinaryTreeElementBase, IStaticReturnType
    {
        public Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public OrOperator(SourceLocation sourceLocation)
        {
            this.SourceLocation = sourceLocation;
        }
    }
}