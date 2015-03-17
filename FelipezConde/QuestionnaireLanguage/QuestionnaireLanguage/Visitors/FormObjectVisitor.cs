using Evaluation.Values;
using FormObjects = QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors.Interfaces;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QuestionnaireLanguage.Visitors
{
    public class FormObjectVisitor : IFormObjectVisitor
    {
        public FormObjects.FormObject VisitFormObject(ASTFormObject.FormObject formObject)
        {
            return Visit((dynamic) formObject);
        }
        public FormObjects.ConditionalObject Visit(ASTFormObject.Conditional node)
        {
            return new FormObjects.ConditionalObject(node);
        }
        public FormObjects.QuestionObject Visit(ASTFormObject.Question node)
        {
            return new FormObjects.QuestionObject(node);
        }
    }
}
