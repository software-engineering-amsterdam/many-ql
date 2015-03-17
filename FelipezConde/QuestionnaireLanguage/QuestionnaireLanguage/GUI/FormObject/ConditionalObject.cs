using AST.Nodes.FormObjects;
using Evaluation.Values;
using QuestionnaireLanguage.Presenter;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors;
using System.Windows;
using Evaluation;

namespace QuestionnaireLanguage.GUI.FormObject
{
    public class ConditionalObject : FormObject
    {
        private Conditional conditionalNode;
        private SymbolTable symbolTable;

        #region Constructors
        public ConditionalObject(Conditional node)
        {
            this.conditionalNode = node;
            symbolTable = new SymbolTable();
        }

        #endregion

        #region IFormElement

        public override UIElement ProcessFormObject(UIElement form)
        {
            Value value = new Evaluator(symbolTable).Evaluate(this.conditionalNode.Condition);

            Widget stackPanelWidget = new StackPanelWidget();
            UIElement customStackPanel = stackPanelWidget.CreateUIControl(ValueVisitor.Visit((dynamic)value));

            return AddChildren(new BodyProcessor().ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion


        public override SymbolTable Register(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;

            return symbolTable;
        }
    }
}
