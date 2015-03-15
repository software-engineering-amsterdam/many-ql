using AST.Nodes.FormObject;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using QuestionnaireLanguage.Visitors.Interfaces;
using ASTFormObject = AST.Nodes.FormObject;

namespace QuestionnaireLanguage.Visitors
{
    public class FormObjectVisitor : IFormObjectVisitor
    {
        public IFormObject VisitFormObject(ASTFormObject.FormObject formObject)
        {
            return Visit((dynamic) formObject);
        }
        public ConditionalObject Visit(Conditional node)
        {
            return new ConditionalObject(node);
        }
        public QuestionObject Visit(Question node)
        {
            return new QuestionObject(node);
        }
    }
}
