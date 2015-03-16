using AST.Nodes.Labels;
using QuestionnaireLanguage.GUI.Widgets;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ILabelVisitor
    {
        LabelWidget Visit(Label value);
    }
}
