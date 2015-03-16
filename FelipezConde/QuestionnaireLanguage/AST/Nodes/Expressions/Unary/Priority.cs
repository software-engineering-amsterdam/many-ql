using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expressions.Unary
{
    public class Priority : BaseUnary
    {
        public Priority(BaseExpression child, PositionInText position)
            : base(child ,position)
        { }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        { return visitor.Visit(this); }

        public override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor)
        {
            throw new System.NotImplementedException();
        }

        public override string ToString()
        {
            return "()";
        }
    }
}
