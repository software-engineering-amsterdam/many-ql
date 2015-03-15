using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expression.Binary
{
    public class LessThan : Binary, IExpression
    {
        public LessThan(IExpression left, IExpression right, PositionInText position)
            : base(left, right, position)
        { }
        
        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "<";
        }
    }

}
