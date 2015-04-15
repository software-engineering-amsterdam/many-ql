using System.Collections.Generic;

namespace QL.AST.Nodes.Branches
{
    public class Block : ElementBase
    {
        public IList<ElementBase> Children { get; set; }

        public Block()
        {
            Children = new List<ElementBase>();
        }

        public Block(IList<ElementBase> children)
        {
            Children = children;
        }

        public Block(IList<ElementBase> children, SourceLocation sourceLocation)
            : this(children)
        {
            SourceLocation = sourceLocation;
        }
    }
}
