using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class TextBoxWidget : Widget
    {
        public override abstract UIElement CreateUIControl(dynamic value);
    }
}
