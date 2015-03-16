using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class LabelWidget : Widget
    {
        public LabelWidget()
        {
        }
        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomLabel() { Content = value, };
        }
    }
}
