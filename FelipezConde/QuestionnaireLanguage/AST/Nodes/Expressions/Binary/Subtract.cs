using AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Binary
{
    public class Subtract : BaseBinary
    {
        public Subtract(BaseExpression left, BaseExpression right, PositionInText position)
            : base(left, right, position)
        { }

        public override string ToString()
        {
            return "-";
        }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
