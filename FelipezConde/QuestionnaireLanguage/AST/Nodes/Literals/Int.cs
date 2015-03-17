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

        public override Types.Type RetrieveType()
        {
            return new Types.IntType();
        }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
