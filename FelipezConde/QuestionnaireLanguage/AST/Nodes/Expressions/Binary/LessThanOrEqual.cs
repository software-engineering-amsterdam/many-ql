using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expressions.Binary
{
    public class LessThanOrEqual : BaseBinary
    {
        public LessThanOrEqual(BaseExpression left, BaseExpression right, PositionInText position)
            : base(left, right, position)
        { }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            throw new System.NotImplementedException();
        }

        public override string ToString()
        {
            return "<=";
        }
    }
}
