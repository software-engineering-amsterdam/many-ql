using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes;
using AST.Nodes.Interfaces;


namespace AST.Nodes.Types
{
    public class Bool : ITypeNode
    {
        private IList<IASTNode> children;

        public Bool()
        {
            children = new List<IASTNode>();
        }

        public void AddChild(IASTNode node)
        {
            children.Add(node);
        }

        public IList<IASTNode> GetChildren()
        {
            return children;
        }
    }
}
