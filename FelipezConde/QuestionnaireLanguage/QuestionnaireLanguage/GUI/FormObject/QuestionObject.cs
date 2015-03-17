using AST.Nodes.FormObjects;
using QuestionnaireLanguage.Presenter;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors;
using System.Windows;
using Evaluation.Values;
using Evaluation;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class QuestionObject : FormObject
    {
        private Question questionNode;
        private SymbolTable symbolTable;

        #region Constructors
        public QuestionObject(Question node)
        {
            this.questionNode = node;
            symbolTable = new SymbolTable();
        }
        #endregion

        #region IFormObject
        public override UIElement ProcessFormObject(UIElement form)
        {
            Widget widget = new TypeToWidget(questionNode.Identifier.Name).VisitValue(questionNode.RetrieveType());
            widget.EventUpdateValue += UpdateValue;

            widget.IsReadOnly = questionNode.Computation != null ? true : false;

            Widget labelWidget = new LabelWidget();

            Value widgetValue = Evaluate();

            AddChildren(labelWidget.CreateUIControl(questionNode.Label.Value), form);
            AddChildren(widget.CreateUIControl(ValueVisitor.Visit((dynamic)widgetValue)), form);

            return form;
        }

        public Value Evaluate()
        {
            Value result;

            if (questionNode.Computation != null)
            {
                result = new Evaluator(symbolTable).Evaluate(questionNode.Computation);
            }
            else
            {
                result = symbolTable.GetValue(questionNode.Identifier);
            }

            return result;
        }

        #endregion

        private void UpdateValue(string id, Value value)
        {
            //TODO: IMPLEMENT EVENTHANDLER
        }

        public override SymbolTable Register(SymbolTable symbolTable)
        {
            TypeToValue visitor = new TypeToValue();
            symbolTable.AddValue(questionNode.Identifier, visitor.VisitValue(questionNode.RetrieveType()));

            this.symbolTable = symbolTable;
            
            return symbolTable;
        }
    }
}
