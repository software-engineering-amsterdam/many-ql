

namespace AST.Nodes
{
    public abstract class Node
    {
        private readonly PositionInText position;
        protected Node(PositionInText position)
        {
            this.position = position;
        }
        
        public PositionInText GetPosition()
        {
            return position;
        }
    }
}
