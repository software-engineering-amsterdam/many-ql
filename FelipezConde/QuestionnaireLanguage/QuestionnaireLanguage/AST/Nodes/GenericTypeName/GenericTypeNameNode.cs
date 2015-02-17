using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.AST.Nodes.GenericTypeName
{
    public class GenericTypeNameNode : iGenericTypeNameNode
    {
        private IList<iASTNode> children;

        public GenericTypeNameNode()
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
