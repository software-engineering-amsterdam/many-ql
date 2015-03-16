using AST.Representation;

namespace AST.Nodes.Labels
{
    public class Label : ASTNode
    {

        public string Value {get; private set;}

        public Label(string value, PositionInText position)
            : base(position)
        {
            this.Value = value;
        }

        public T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
