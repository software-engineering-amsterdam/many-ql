using AST.Nodes;
using AST.Nodes.Interfaces;

using System;

namespace AST.Nodes.Literals
{
    public abstract class Literal : BaseExpression, IHasType
    {
        protected Literal(PositionInText position)
            : base(position) {}
        public abstract Types.Type RetrieveType();

        public abstract override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor);
    } 
}
