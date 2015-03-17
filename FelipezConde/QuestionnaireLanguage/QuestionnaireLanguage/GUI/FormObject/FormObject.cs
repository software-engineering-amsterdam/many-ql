using Evaluation;
using QuestionnaireLanguage.Events;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public abstract class FormObject
    {
        public virtual EventUpdateValue EventUpdateValue { get; set; }
        public abstract UIElement ProcessFormObject(UIElement form);
        public abstract SymbolTable Register(SymbolTable symbolTable);
        public virtual UIElement AddChild(UIElement element, UIElement form)
        {
            ((StackPanel)form).Children.Add(element);
            return form;
        }
    }
}
