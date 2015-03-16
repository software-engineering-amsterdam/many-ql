using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions
{
    public abstract class BaseUnary : BaseExpression
    {
        private readonly BaseExpression child;

        protected BaseUnary(BaseExpression child, PositionInText pos)
            :base(pos)
        { this.child = child; }

        public BaseExpression GetChildExpression()
        { return child; }

        public abstract override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor);
    }
}
