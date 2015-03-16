using Evaluation;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public abstract class FormObject
    {
        public abstract UIElement ProcessFormObject(UIElement form);
        public abstract SymbolTable Register(SymbolTable symbolTable);
        public virtual UIElement AddChildren(UIElement element, UIElement form)
        {
            ((CustomStackPanel)form).Children.Add(element);
            return form;
        }
    }
}
