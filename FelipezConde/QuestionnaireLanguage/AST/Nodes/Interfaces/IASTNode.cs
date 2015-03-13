using AST.Representation;

namespace AST.Nodes.Interfaces
{
    public interface IASTNode : IVisitable
    {
        PositionInText GetPosition();

    }
}
