using AST.Nodes.Interfaces;

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

    }
}
