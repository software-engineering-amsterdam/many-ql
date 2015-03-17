
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
    }
}
