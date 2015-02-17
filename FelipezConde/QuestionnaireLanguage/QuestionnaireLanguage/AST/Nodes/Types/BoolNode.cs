using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuestionnaireLanguage;
using QuestionnaireLanguage.AST.Nodes;


namespace QuestionnaireLanguage.AST.Nodes.Types
{
    public class BoolNode : iTypeNode
    {
        private IList<iASTNode> children;

        public BoolNode()
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
