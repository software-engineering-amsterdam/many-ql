using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Resources;

namespace AST.Nodes.TypeName
{
    public class TypeName : IType
    {
        public string Representation { get; private set; }
        private PositionInText position;
        private Types type;

        public TypeName(string representation, Types type, PositionInText position )
        {
            this.Representation = representation;
            this.position = position;
            this.type = type;
        }

        public PositionInText GetPosition()
        {
            return position;
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
