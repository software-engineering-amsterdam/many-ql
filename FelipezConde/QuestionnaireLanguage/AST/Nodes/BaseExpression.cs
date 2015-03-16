using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes
{
    public abstract class BaseExpression : ASTNode, IVisitable
    {
        public BaseExpression(PositionInText position)
            : base(position) { }

        public abstract T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor);


        public abstract T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
