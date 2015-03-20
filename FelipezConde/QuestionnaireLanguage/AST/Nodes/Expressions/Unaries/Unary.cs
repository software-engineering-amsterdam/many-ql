using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Unaries
{
    public abstract class Unary : Expression
    {
        private readonly Expression child;

        protected Unary(Expression child, PositionInText pos)
            :base(pos)
        { this.child = child; }

        public Expression GetChildExpression()
        { return child; }

        public abstract override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor);
    }
}
