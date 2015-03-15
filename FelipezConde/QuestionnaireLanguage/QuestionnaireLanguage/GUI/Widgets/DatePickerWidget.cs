using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System;
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
