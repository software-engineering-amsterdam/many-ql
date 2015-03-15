using AST.Nodes.Interfaces;

namespace AST.Nodes.Expression.Binary
{
    public class GreaterThanOrEqual : Binary, IExpression
    {
        public GreaterThanOrEqual(IExpression left, IExpression right, Representation.PositionInText position)
            : base(left, right, position)
        { }
        
        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return ">=";
        }
    }
}
