using AST.Nodes.FormObject;
using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using QuestionnaireLanguage.GUI.Widgets;
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
            //Processor.Evaluate(this.conditionalNode.Condition);

            Widget stackPanelWidget = new StackPanelWidget(false);
            UIElement customStackPanel = stackPanelWidget.CreateUIControl();
            
            //stackPanelWidget.Id to identify this conditional

            //Evaluate the expression
            //customStackPanel.Visibility = Visibility.Hidden;

            /*
             *
             * Verify the conditional expression to set visibility
             * 
             * Get Id of elements from the expression (if exist).
             * Find elements in the form and assign stack
             */
            
            return AddChildren(Processor.ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion

        #region Private Methods

        #endregion
    }
}
