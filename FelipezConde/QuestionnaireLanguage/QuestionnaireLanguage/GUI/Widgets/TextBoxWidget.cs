using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public abstract class TextBoxWidget : Widget
    {
        public override abstract UIElement CreateUIControl(dynamic value);
    }
}
