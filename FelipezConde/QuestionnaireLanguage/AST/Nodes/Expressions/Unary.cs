using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions
{
    public abstract class BaseUnary : BaseExpression
    {
        private readonly BaseExpression child;

        protected BaseUnary(BaseExpression child, Representation.PositionInText pos)
            :base(pos)
        { this.child = child; }

        public BaseExpression GetChildExpression()
        { return child; }

        public override abstract T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
