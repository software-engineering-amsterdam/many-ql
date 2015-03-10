using AST.Nodes.Interfaces;
using QuestionnaireLanguage.GUI.Factories.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;
using Labels = AST.Nodes.Labels;

namespace QuestionnaireLanguage.Visitors
{
    public class WidgetVisitor : IWidgetVisitor
    {
        private string id;
        public WidgetVisitor(string id)
        {
            this.id = id;
        }
        public Widget VisitValue(IValue value)
        {
            return Visit((dynamic)value);
        }
        public StringTextBoxWidget Visit(Values.String stringValue)
        {
            return WidgetFactory.GetWidget(id,stringValue);
        }

        public IntegerTextBoxWidget Visit(Values.Int intValue)
        {
            return WidgetFactory.GetWidget(id, intValue);
        }

        public CheckboxWidget Visit(Values.Bool boolValue)
        {
            return WidgetFactory.GetWidget(id, boolValue);
        }

        public LabelWidget Visit(Labels.Label value)
        {
            return WidgetFactory.GetWidget(value);
        }
    }
}
