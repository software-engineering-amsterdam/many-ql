using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.FormSection;
using AST.Nodes.Interfaces;


namespace AST.Nodes
{
    public class Form : IASTNode
    {
        private IList<IASTNode> children;

        public Form()
        {
            children = new List<IASTNode>();
        }

        public void AddChild(IASTNode formSection)
        {
            children.Add(formSection);
        }

        public IList<IASTNode> GetChildren()
        {
            return children;
        }


    }
}
