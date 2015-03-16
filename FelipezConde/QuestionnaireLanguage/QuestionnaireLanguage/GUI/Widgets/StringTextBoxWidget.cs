using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class StringTextBoxWidget : TextBoxWidget
    {
        public StringTextBoxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            CustomTextBox customTextBox = new CustomTextBox(new StringHandler()) { Name = Id, Text = value.ToString(), IsReadOnly = IsReadOnly };
            customTextBox.eventUpdateValue += UpdateValue;

            return customTextBox;
        }
    }
}
