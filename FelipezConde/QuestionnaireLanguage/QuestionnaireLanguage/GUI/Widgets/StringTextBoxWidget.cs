using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class StringTextBoxWidget : TextBoxWidget
    {
        public StringTextBoxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(object value)
        {
            return new CustomTextBox(false) { Name = Id, Text = value.ToString(), IsReadOnly = IsComputed };
        }
    }
}
