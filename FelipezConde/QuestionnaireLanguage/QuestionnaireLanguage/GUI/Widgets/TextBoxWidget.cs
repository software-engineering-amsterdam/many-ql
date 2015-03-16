using Evaluation.Values;
using QuestionnaireLanguage.Events;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public abstract class TextBoxWidget : Widget
    {
        public override EventUpdateValue EventUpdateValue { get; set; }
        public override abstract UIElement CreateUIControl(dynamic value);

        public virtual void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
