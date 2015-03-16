using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes.Expressions.Binary
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

        public abstract override T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
