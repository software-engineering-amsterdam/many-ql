using System.Collections.Generic;

namespace QL.AST.Nodes.Branches
{
    public class Block: ElementBase
    {
        public IList<ElementBase> Children { get; set; }

        public Block()
        {
            Children = new List<ElementBase>();
        }


    }
}
