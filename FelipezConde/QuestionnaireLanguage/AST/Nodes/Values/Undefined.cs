using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Values
{
    public class Undefined : IValue
    {
        public string MakeString()
        {
            return "undefined";
        }

        public Representation.PositionInText GetPosition()
        {
            return new Representation.PositionInText();
        }

        public void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public bool IsOfType(IValue type)
        {
            return false;
        }
    }
}
