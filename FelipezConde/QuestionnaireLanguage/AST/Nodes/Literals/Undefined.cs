using System;

namespace AST.Nodes.Literals
{
    public class Undefined : Literal
    {
        public override string ToString()
        {
            return "undefined";
        }

        public override Representation.PositionInText GetPosition()
        {
            return new Representation.PositionInText();
        }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override object GetValueType()
        {
            return this;
        }

        public override Literal Equal(Literal value)
        {
            throw new NotImplementedException();
        }

        public override Literal NotEqual(Literal value)
        {
            throw new NotImplementedException();
        }
    }
}
