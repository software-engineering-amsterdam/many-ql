using AST.Nodes.FormObject;
using AST.Nodes.Literals;
using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class ConditionalObject : IFormObject
    {
        private Conditional conditionalNode;

        #region Constructors
        public ConditionalObject(Conditional node)
        {
            this.conditionalNode = node;
        }

        #endregion

        #region IFormElement

        public UIElement ProcessFormObject(UIElement form)
        {
            Literal value = MainController.Evaluate(this.conditionalNode.Condition);

            Widget stackPanelWidget = new StackPanelWidget();
            UIElement customStackPanel = stackPanelWidget.CreateUIControl(ValueVisitor.Visit((dynamic)value));

            return MainController.AddChildren(MainController.ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion
    }
}
