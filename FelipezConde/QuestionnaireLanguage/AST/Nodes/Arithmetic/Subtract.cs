using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Arithmetic
{
    public class Subtract : IArithmeticNode
    {
        private IList<IASTNode> children;

        public Subtract()
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
