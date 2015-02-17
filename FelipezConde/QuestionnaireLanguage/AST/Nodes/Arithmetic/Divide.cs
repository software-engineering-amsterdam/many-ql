using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Arithmetic
{
    public class Divide : IArithmeticNode
    {
        private IList<IASTNode> children;

        public Divide()
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
