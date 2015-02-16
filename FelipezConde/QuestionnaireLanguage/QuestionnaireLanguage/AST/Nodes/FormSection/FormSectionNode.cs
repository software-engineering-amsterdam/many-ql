using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuestionnaireLanguage;


namespace QuestionnaireLanguage.AST.Nodes.FormSection
{
    public class FormSectionNode : iFormSectionNode
    {
        private IList<iASTNode> children;

        public FormSectionNode()
        {
            children = new List<iASTNode>();
        }

        public void AddChild( iASTNode formSection)
        {
            children.Add(formSection);
        }

        public IList<iASTNode> GetChildren()
        {
            return children;
        }

    }
}
