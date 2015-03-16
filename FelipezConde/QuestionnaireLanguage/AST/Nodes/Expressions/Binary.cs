using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expressions
{
    public abstract class BaseBinary : BaseExpression
    {
        private readonly BaseExpression left; 
        private readonly BaseExpression right;

        protected BaseBinary(BaseExpression left, BaseExpression right, PositionInText pos)
            :base(pos)
        {
            this.left = left; 
            this.right = right;
        }

        public BaseExpression Left()
        { return left; }

        public BaseExpression Right()
        { return right; }

        public abstract override T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
