using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Nodes.FormObject
{
    public class FieldNode : iFormObjectNode
    {
        private IList<iASTNode> children;

        public FieldNode()
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
