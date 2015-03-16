using Expressions = AST.Nodes.Interfaces;

namespace AST.Nodes.Expressions.Binary
{
    public class GreaterThanOrEqual : Binary
    {
        public GreaterThanOrEqual(Expression left, Expression right, Representation.PositionInText position)
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
