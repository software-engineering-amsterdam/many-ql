using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class LessThanEqualToOperator : BinaryTreeElementBase, IStaticReturnType
    {

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public LessThanEqualToOperator(SourceLocation sourceLocation)
        {
            // TODO: Complete member initialization
            this.SourceLocation = sourceLocation;
        }
    }
}