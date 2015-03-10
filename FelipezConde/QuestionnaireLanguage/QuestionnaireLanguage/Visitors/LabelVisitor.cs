using AST.Nodes.Interfaces;
using AST.Nodes.Labels;
using QuestionnaireLanguage.GUI.Factories.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.Visitors
{
    public class LabelVisitor : ILabelVisitor
    {
        public Widget VisitValue(ILabel value)
        {
            return Visit((dynamic)value);
        }
        public LabelWidget Visit(Label node)
        {
            return WidgetFactory.GetWidget(node);
        }
    }
}
