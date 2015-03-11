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
using Values = AST.Nodes.Values;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class QuestionObject : ObjectBase, IFormObject
    {
        private Question questionNode;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            Processor.AddValue(questionNode.Identifier, questionNode.RetrieveType());
        }
        #endregion

        #region Private Methods
        #endregion

        #region IFormObject
        public UIElement ProcessFormObject(UIElement form)
        {
            Widget widget = new TypeToWidgetVisitor(questionNode.Identifier.Name).VisitValue(questionNode.RetrieveType());
            Widget labelWidget = new LabelVisitor().VisitValue(questionNode.Label);

            Values.Value widgetValue = Processor.GetObjectValue(questionNode.Identifier);

            widgetValue = ProcessComputation(widgetValue);

            AddChildren(labelWidget.CreateUIControl(questionNode.Label.Value), form);
            AddChildren(widget.CreateUIControl(ValueVisitor.Visit((dynamic)widgetValue)), form);

            return form;
        }

        public Values.Value ProcessComputation(Values.Value value)
        {
            if (questionNode.Computation != null)
            {
                value = Processor.Evaluate(questionNode.Computation);
            }

            return value;
        }

        #endregion
    }
}
