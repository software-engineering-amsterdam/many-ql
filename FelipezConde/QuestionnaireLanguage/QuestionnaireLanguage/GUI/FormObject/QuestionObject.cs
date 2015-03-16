using AST.Nodes.FormObject;
using Evaluator.Values;
using QuestionnaireLanguage.Presenter;
using QuestionnaireLanguage.GUI.FormObject.Interface;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors;
using System.Windows;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class QuestionObject : IFormObject
    {
        private Question questionNode;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            MainPresenter.AddValue(questionNode.Identifier, questionNode.RetrieveType());
        }
        #endregion

        #region IFormObject
        public UIElement ProcessFormObject(UIElement form)
        {
            Widget widget = new TypeToWidget(questionNode.Identifier.Name).VisitValue(questionNode.RetrieveType());
            widget.IsReadOnly = questionNode.Computation != null ? true : false;

            Widget labelWidget = new LabelWidget();

            Value widgetValue = Evaluate();

            MainPresenter.AddChildren(labelWidget.CreateUIControl(questionNode.Label.Value), form);
            MainPresenter.AddChildren(widget.CreateUIControl(ValueVisitor.Visit((dynamic)widgetValue)), form);

            return form;
        }

        public Value Evaluate()
        {
            Value result;

            if (questionNode.Computation != null)
            {
                result = MainPresenter.Evaluate(questionNode.Computation);
            }
            else
            {
                result = MainPresenter.GetObjectValue(questionNode.Identifier);
            }

            return result;
        }

        #endregion
    }
}
