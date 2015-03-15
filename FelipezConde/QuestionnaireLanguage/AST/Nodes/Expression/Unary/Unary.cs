using AST.Nodes.Interfaces;

namespace AST.Nodes.Expression.Unary
{
    public class Unary : ASTNode, IExpression
    {
        private readonly IExpression child;
        
        protected Unary(IExpression child, Representation.PositionInText pos)
            :base(pos)
        { this.child = child; }

        public IExpression GetChildExpression()
        { return child; }

        public virtual T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return this.Accept(visitor);
        }
    }
}
