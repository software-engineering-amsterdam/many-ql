using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Resources;
using AST.Representation;

namespace AST.Nodes.Values
{
    public class Unknown : ValueNode<Null>
    {
        public Unknown(string parsedValue, Null placeholder, PositionInText position)
            : base(parsedValue, placeholder, position)
        {}

        public override Types GetType(Storage.ISymbolTable lookup)
        {
            return Types.UNDEFINED;
        }

        //Visitor Methods
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
