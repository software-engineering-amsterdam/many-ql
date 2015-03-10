using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Values
{
    public class Undefined : Value
    {
        public override string MakeString()
        {
            return "undefined";
        }

        public override Representation.PositionInText GetPosition()
        {
            return new Representation.PositionInText();
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override object GetType(Storage.ISymbolTable lookup)
        {
            throw new NotImplementedException();
        }

        public override Value Equal(Value value)
        {
            throw new NotImplementedException();
        }

        public override Value NotEqual(Value value)
        {
            throw new NotImplementedException();
        }
    }
}
