using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Labels
{
    public class Label : ASTNode, ILabel
    {
        private string parsedString;
        public string Value {get; private set;}

        public Label(string parsedString, string value, PositionInText position)
            : base(position)
        {
            this.parsedString = parsedString;
            this.Value = value;
        }

        public override string GetParsedString()
        {
            return parsedString;
        }

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
