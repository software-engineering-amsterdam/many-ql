using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class GreaterThanOperator : BinaryTreeElementBase, IStaticReturnType
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public GreaterThanOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}