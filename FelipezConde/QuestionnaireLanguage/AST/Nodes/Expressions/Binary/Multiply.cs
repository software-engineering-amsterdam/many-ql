using AST.Nodes.Interfaces;


namespace AST.Nodes.Expressions.Binary
{
    public class Multiply : BaseBinary
    {
        public Multiply(BaseExpression left, BaseExpression right, PositionInText position)
            : base(left, right, position)
        { }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "*";
        }
    }
}
