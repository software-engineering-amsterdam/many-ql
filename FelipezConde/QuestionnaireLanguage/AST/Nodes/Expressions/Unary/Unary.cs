using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Unary
{
    public abstract class Unary : Expression
    {
        private readonly Expression child;

        protected Unary(Expression child, Representation.PositionInText pos)
            :base(pos)
        { this.child = child; }

        public Expression GetChildExpression()
        { return child; }

        public abstract override T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
