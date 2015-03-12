using AST.Nodes.FormObject;
using ASTInterface = AST.Nodes.Interfaces;
using AST.Nodes.Values;
using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class ConditionalObject : ObjectBase, IFormObject
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
            Value value = Processor.Evaluate(this.conditionalNode.Condition);

            Widget stackPanelWidget = new StackPanelWidget();
            UIElement customStackPanel = stackPanelWidget.CreateUIControl(ValueVisitor.Visit((dynamic)value));

            return AddChildren(Processor.ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion

        #region Private Methods

        #endregion
    }
}
