using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Binary
{
    public class GreaterThanOrEqual : BaseBinary
    {
        public GreaterThanOrEqual(BaseExpression left, BaseExpression right, Representation.PositionInText position)
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
            return ">=";
        }
    }
}
