using AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Unaries
{
    public class Negate : Unary
    {
        public Negate(Expression child, PositionInText position)
            : base(child, position)
        {}

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "!";
        }
    }
}


 