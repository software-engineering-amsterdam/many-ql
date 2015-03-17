using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class LabelWidget : Widget
    {
        public override EventUpdateValue EventUpdateValue { get; set; }
        public LabelWidget()
        {
        }
        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomLabel() { Content = value, };
        }
    }
}
