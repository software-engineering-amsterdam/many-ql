using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class StackPanelWidget : Widget
    {
        public override EventUpdateValue EventUpdateValue { get; set; }

        public StackPanelWidget()
        {
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomStackPanel() { Visibility = value ? Visibility.Visible : Visibility.Collapsed };
        }
    }
}
