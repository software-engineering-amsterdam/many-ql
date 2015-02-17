using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Interfaces;


namespace AST.Nodes.FormSection
{
    public class FormSection : IFormSectionNode
    {
        private IList<IASTNode> children;

        public FormSection()
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
