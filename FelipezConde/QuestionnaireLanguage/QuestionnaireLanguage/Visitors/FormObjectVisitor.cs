using Evaluation.Values;
using FormObjects = QuestionnaireLanguage.GUI.FormObject;
using ASTFormObject = AST.Nodes.FormObjects;
using AST.ASTVisitors.Interfaces;

namespace QuestionnaireLanguage.Visitors
{
    public class FormObjectVisitor : IFormObjectVisitor<FormObjects.FormObject>
    {
        public FormObjects.FormObject Visit(ASTFormObject.Conditional node)
        {
            return new FormObjects.ConditionalObject(node);
        }

        public FormObjects.FormObject Visit(ASTFormObject.Question node)
        {
            return new FormObjects.QuestionObject(node);
        }
    }
}
