using AST.Nodes.Values;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;
using Labels = AST.Nodes.Labels;

namespace QuestionnaireLanguage.GUI.Factories.Widgets
{
    internal static class WidgetFactory
    {
        internal static StringTextBoxWidget GetWidget(string id, Values.String node)
        {
            return new StringTextBoxWidget(id, node);
        }

        internal static CheckboxWidget GetWidget(string id, Bool node)
        {
            return new CheckboxWidget(id, node);
        }

        internal static IntegerTextBoxWidget GetWidget(string id, Int node)
        {
            return new IntegerTextBoxWidget(id, node);
        }

        internal static LabelWidget GetWidget(Labels.Label node)
        {
            return new LabelWidget(node);
        }

        //internal static DatePickerWidget GetControlElement(string id, Date node)
        //{
        //    return new DatePickerWidget(id, node);
        //}
    }
}
