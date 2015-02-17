using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Nodes.Types
{
    public class IntNode : iTypeNode
    {
        private IList<iASTNode> children;

        public IntNode()
        {
            children = new List<iASTNode>();
        }

        public void AddChild(iASTNode node)
        {
            children.Add(node);
        }

        public IList<iASTNode> GetChildren()
        {
            return children;
        }
    }
}
