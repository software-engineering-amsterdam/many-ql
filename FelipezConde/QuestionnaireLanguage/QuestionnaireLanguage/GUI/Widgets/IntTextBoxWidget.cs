using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class IntTextBoxWidget : TextBoxWidget
    {
        public IntTextBoxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            CustomTextBox customTextBox = new CustomTextBox(new IntHandler()) { Name = Id, Text = GetControlValue(value), IsReadOnly = IsReadOnly };
            customTextBox.eventUpdateValue += UpdateValue;

            return customTextBox;
        }

        private string GetControlValue(dynamic value)
        {
            string result = string.Empty;

            int outParse;
            if (int.TryParse(value.ToString(), out outParse))
            {
                if (outParse != int.MinValue)
                {
                    result = value.ToString();
                }
            }

            return result;
        }
    }
}
