using AST.Representation;
using System;

namespace AST.Nodes.Literals
{
    public class Int : Literal
    {
        private readonly int value;

        public Int(int value, PositionInText positionInText)
            :base(positionInText)
        {
            this.value = value;
        }

        public int GetValue()
        {
            return value;
        }

        public override string ToString()
        {
            return "int";
        }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override Types.Type RetrieveType()
        {
            throw new NotImplementedException();
        }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            throw new NotImplementedException();
        }
    }
}
