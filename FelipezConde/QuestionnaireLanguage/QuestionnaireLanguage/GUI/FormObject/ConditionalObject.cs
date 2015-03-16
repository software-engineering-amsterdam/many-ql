using AST.Nodes.FormObjects;
using Evaluation.Values;
using QuestionnaireLanguage.Presenter;
using QuestionnaireLanguage.GUI.FormObject.Interface;
using QuestionnaireLanguage.GUI.FormObject;
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
            Value value = MainPresenter.Evaluate(this.conditionalNode.Condition);

            Widget stackPanelWidget = new StackPanelWidget();
            UIElement customStackPanel = stackPanelWidget.CreateUIControl(ValueVisitor.Visit((dynamic)value));

            return MainPresenter.AddChildren(MainPresenter.ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion
    }
}
