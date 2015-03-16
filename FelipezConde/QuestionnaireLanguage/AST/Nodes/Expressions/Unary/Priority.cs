using AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Unary
{
    public class Priority : BaseUnary
    {
        public Priority(BaseExpression child, PositionInText position)
            : base(child ,position)
        { }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "()";
        }
    }
}
