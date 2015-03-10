using AST.Nodes.FormObject;
using ASTIFormObject = AST.Nodes.Interfaces;
using QuestionnaireLanguage.GUI.Factories.Widgets;
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
using AST.Resources;
using QuestionnaireLanguage.Visitors;
using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Controller;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class QuestionObject : ObjectBase, IFormObject
    {
        private Question questionNode;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            Processor.AddValue(questionNode.Identifier, questionNode.Value);
        }
        #endregion

        #region Private Methods
        #endregion

        #region IFormObject
        public UIElement ProcessFormObject(UIElement form)
        {
            Widget widget = new WidgetVisitor(questionNode.Identifier).VisitValue(questionNode.Value);
            Widget labelWidget = new LabelVisitor().VisitValue(questionNode.Label);

            AddChildren(labelWidget.CreateUIControl(), form);
            AddChildren(widget.CreateUIControl(), form);

            return form;
        }
        #endregion
    }
}
