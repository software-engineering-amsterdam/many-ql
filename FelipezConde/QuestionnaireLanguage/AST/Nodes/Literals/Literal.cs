using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;

namespace AST.Nodes.Literals
{
    public abstract class Literal : Expression, IHasType
    {
        protected Literal(PositionInText position)
            : base(position) {}
        public abstract Types.Type RetrieveType();

        public abstract override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor);
    } 
}
