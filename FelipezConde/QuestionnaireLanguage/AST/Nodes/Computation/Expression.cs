using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Computation
{
    public class Expression : ASTNode, IComputation, IExpression
    {
        private string parsedString;
        public IExpression ExpressionValue {get; private set;}

        public Expression(string parsedString, IExpression expression, PositionInText positionInText)
            : base(positionInText)
        {
            this.parsedString = parsedString;
            this.ExpressionValue = expression;
        }
        public override string GetParsedString()
        {
            return parsedString;
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
