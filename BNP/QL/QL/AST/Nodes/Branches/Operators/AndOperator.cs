using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches.Operators
{
    public class AndOperator : BinaryTreeElementBase, IStaticReturnType
    {
        public  Type GetReturnType()
        {
            return (new Yesno()).GetReturnType();
        }

        public AndOperator(SourceLocation sourceLocation)
        {
            this.SourceLocation = sourceLocation;
        }
    }
}