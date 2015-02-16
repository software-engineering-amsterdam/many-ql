using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuestionnaireLanguage;
using QuestionnaireLanguage.AST.Nodes.FormSection;


namespace QuestionnaireLanguage.AST.Nodes
{
    public class FormNode : iASTNode
    {
        private IList<iASTNode> children;

        public FormNode()
        {
            children = new List<iASTNode>();
        }

        public void AddChild(iASTNode formSection)
        {
            children.Add(formSection);
        }

        public IList<iASTNode> GetChildren()
        {
            return children;
        }


    }
}
