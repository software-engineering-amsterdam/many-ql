
namespace AST.Nodes.Expressions.Binaries
{
    public abstract class Binary : Expression
    {
        private readonly Expression left; 
        private readonly Expression right;

        protected Binary(Expression left, Expression right, PositionInText pos)
            :base(pos)
        {
            this.left = left; 
            this.right = right;
        }

        public Expression Left()
        { return left; }

        public Expression Right()
        { return right; }

    }
}
