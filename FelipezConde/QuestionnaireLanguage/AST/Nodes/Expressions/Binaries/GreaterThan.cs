
namespace AST.Nodes.Expressions.Binaries
{
    public class GreaterThan : Binary
    {
        
        public GreaterThan(Expression left, Expression right, PositionInText position)
            : base(left, right, position)
        {}

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return ">";
        }
    }
}
