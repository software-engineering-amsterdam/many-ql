using AST.Nodes;
using AST.Nodes.Interfaces;
using AST.Representation;
using System;

namespace AST.Nodes.Literals
{
    public abstract class Literal : BaseExpression, IHasType
    {
        protected Literal(PositionInText position)
            : base(position) {}
        public virtual Types.Type RetrieveType(){throw new NotImplementedException();}

        public abstract override T Accept<T>(ASTVisitors.Interfaces.IExpressionVisitor<T> visitor);
    } 
}
