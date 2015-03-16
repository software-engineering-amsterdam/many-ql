using AST.Nodes.FormObjects;
using QuestionnaireLanguage.GUI.FormObject;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface IFormObjectVisitor
    {
        QuestionObject Visit(Question question);
        ConditionalObject Visit(Conditional conditional);
    }
}
