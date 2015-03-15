using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class IntegerTextBoxWidget : TextBoxWidget
    {
        public IntegerTextBoxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomTextBox(true) { Name = Id, Text = GetControlValue(value), IsReadOnly = IsComputed };
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
