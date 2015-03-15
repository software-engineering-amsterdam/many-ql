using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class StackPanelWidget : Widget
    {
        public StackPanelWidget()
        {
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomStackPanel() { Visibility = value ? Visibility.Visible : Visibility.Hidden };
        }
    }
}
