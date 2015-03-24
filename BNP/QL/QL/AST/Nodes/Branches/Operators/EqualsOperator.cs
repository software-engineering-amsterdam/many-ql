using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class EqualsOperator : BinaryTreeElementBase, IStaticReturnType
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public EqualsOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}