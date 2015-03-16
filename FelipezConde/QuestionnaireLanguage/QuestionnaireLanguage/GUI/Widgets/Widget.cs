using QuestionnaireLanguage.GUI.FormObject.Interface;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public abstract class Widget
    {
        public virtual string Id { get; set; }

        public virtual bool IsReadOnly { get; set; }

        public abstract UIElement CreateUIControl(dynamic value);
    }
}
