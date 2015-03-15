using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expression.Binary
{
    public abstract class Binary : ASTNode, IExpression
    {
        private readonly IExpression left; 
        private readonly IExpression right;

        protected Binary(IExpression left, IExpression right, PositionInText pos)
            :base(pos)
        {
            this.left = left; 
            this.right = right;
        }

        public IExpression Left()
        { return left; }

        public IExpression Right()
        { return right; }

        public abstract T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
