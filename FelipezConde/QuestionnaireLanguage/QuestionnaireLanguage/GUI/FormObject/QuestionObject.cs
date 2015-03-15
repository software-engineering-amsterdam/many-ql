using AST.Nodes.FormObject;
using ASTIFormObject = AST.Nodes.Interfaces;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using QuestionnaireLanguage.GUI.Interfaces.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using QuestionnaireLanguage.Visitors;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Controller;
using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class QuestionObject : IFormObject
    {
        private Question questionNode;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            MainController.AddValue(questionNode.Identifier, questionNode.RetrieveType());
        }
        #endregion

        #region Private Methods
        #endregion

        #region IFormObject
        public UIElement ProcessFormObject(UIElement form)
        {
            Widget widget = new TypeToWidgetVisitor(questionNode.Identifier.Name).VisitValue(questionNode.RetrieveType());
            widget.IsComputed = questionNode.Computation != null ? true : false;

            Widget labelWidget = new LabelVisitor().VisitValue(questionNode.Label);

            Values.Literal widgetValue = ProcessComputation();

            MainController.AddChildren(labelWidget.CreateUIControl(questionNode.Label.Value), form);
            MainController.AddChildren(widget.CreateUIControl(ValueVisitor.Visit((dynamic)widgetValue)), form);

            return form;
        }

        public Values.Literal ProcessComputation()
        {
            Values.Literal result;

            if (questionNode.Computation != null)
            {
                result = MainController.Evaluate(questionNode.Computation);
            }
            else
            {
                result = MainController.GetObjectValue(questionNode.Identifier);
            }

            return result;
        }

        #endregion
    }
}
