
namespace AST.Nodes.Expressions
{
    public abstract class Expression : Node
    {
        public Expression(PositionInText position)
            : base(position) { }

        public abstract T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor);
    }
}
