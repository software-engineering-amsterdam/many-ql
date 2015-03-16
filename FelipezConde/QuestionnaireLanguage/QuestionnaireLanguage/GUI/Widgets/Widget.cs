using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class Widget : IWidget
    {
        public virtual string Id { get; set; }

        public virtual bool IsComputed { get; set; }

        public abstract UIElement CreateUIControl(dynamic value);
    }
}
