using AST.Nodes.Interfaces;
using AST.Representation;

namespace AST.Nodes
{
    public abstract class Expression : ASTNode, IVisitable
    {
        public Expression(PositionInText position)
            : base(position) { }

        public abstract T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
