using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Expression
{
    public class Container : ASTNode, IExpression
    {
        public ILiteral Value { get; private set; }
        private string parsedString;

        public Container(string parsedString, ILiteral value, PositionInText position)
            : base(position)
        {
            this.Value = value;
            this.parsedString = parsedString;
        }
        public override string GetParsedString()
        {
            return parsedString;
        }

        //Visitor Methods
        public void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
