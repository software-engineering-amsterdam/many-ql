using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Nodes.FormObject
{
    public class ConditionalNode : iFormObjectNode
    {
        private IList<iASTNode> children;

        public ConditionalNode()
        {
            children = new List<iASTNode>();
        }

        public void AddChild( iASTNode conditionalNode)
        {
            children.Add(conditionalNode);
        }

        public IList<iASTNode> GetChildren()
        {
            return children;
        }
    }
}
