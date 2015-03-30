using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class GreaterThanEqualToOperator : BinaryTreeElementBase, IStaticReturnType
    {

        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public GreaterThanEqualToOperator(SourceLocation sourceLocation)
        {
            this.SourceLocation = sourceLocation;
        }
    }
}