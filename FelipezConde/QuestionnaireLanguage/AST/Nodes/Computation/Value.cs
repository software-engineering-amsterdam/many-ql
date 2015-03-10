using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;

namespace AST.Nodes.Computation
{
    public class Value : ASTNode, IComputation
    {
        private string parsedString;
        public IValue ElementValue { get; private set; }

        public Value(string parsedString, IValue value, PositionInText positionInText)
            : base(positionInText)
        {
            this.parsedString = parsedString;
            this.ElementValue = value;
        }
        public override string GetParsedString()
        {
            return parsedString;
        }

        public override void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
