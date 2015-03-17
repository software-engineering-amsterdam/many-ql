using AST.Nodes.Interfaces;

namespace AST.Nodes
{
    public abstract class BaseExpression : ASTNode
    {
        public BaseExpression(PositionInText position)
            : base(position) { }

        public abstract T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor);
    }
}
