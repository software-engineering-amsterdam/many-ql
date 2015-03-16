using Evaluation.Values;
using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class CheckboxWidget : Widget
    {
        public override EventUpdateValue EventUpdateValue { get; set; }

        public CheckboxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            CustomCheckBox customCheckBox = new CustomCheckBox() { Name = Id, IsChecked = value, IsEnabled = !IsReadOnly };
            customCheckBox.eventUpdateValue += UpdateValue;
            
            return customCheckBox;
        }

        private void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
