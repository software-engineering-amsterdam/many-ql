

namespace AST.Nodes
{
    public abstract class ASTNode
    {
        private readonly PositionInText position;
        protected ASTNode(PositionInText position)
        {
            this.position = position;
        }
        
        public PositionInText GetPosition()
        {
            return position;
        }
    }
}
