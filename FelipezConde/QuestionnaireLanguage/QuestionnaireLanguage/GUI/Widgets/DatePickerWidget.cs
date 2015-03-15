using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
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
    class DatePickerWidget : Widget
    {
        public DatePickerWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            DateTime outDate;
            DateTime.TryParse(value, out outDate);

            return new CustomDatePicker() { Name = Id, Focusable = false, IsEnabled = !IsComputed,
                SelectedDate = (outDate == DateTime.MinValue) ? DateTime.Today : outDate };
        }
    }
}
