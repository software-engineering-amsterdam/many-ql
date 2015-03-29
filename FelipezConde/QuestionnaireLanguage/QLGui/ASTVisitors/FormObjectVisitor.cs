using AST.VisitorInterfaces;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QLGui.ASTVisitors
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
