using AST.Nodes.Values;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.GUI.CustomControls;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    class DatePickerWidget : Widget<CustomDatePicker>
    {
        public DatePickerWidget(string id, Date node)
        {
            CreateUIControl();
            Id = id;
        }

        public UIElement CreateUIControl()
        {
            return new CustomDatePicker() { Name = Id, Focusable = false };
        }
    }
}
