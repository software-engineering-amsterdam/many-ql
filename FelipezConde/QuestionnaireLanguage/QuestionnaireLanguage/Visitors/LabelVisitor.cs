using AST.Nodes.Labels;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors.Interfaces;

namespace QuestionnaireLanguage.Visitors
{
    public class LabelVisitor : ILabelVisitor
    {
        public Widget VisitValue(Label value)
        {
            return Visit((dynamic)value);
        }
        public LabelWidget Visit(Label node)
        {
            return new LabelWidget();
        }
    }
}
