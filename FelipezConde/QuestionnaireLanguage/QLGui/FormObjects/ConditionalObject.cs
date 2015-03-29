using AST.Nodes.FormObjects;
using Evaluation;
using Evaluation.Values;
using QLGui.Controllers;
using QLGui.ValueVisitors;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.FormObjects
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
            Value value = this.conditionalNode.Condition.Accept(new Evaluator(symbolTable));

            StackPanel stackPanelWidget = new StackPanel();

            UIElement customStackPanel = value.Accept(new ValueToStackPanel());

            SubController conditionalBodyProcessor = new SubController(symbolTable);
            conditionalBodyProcessor.EventUpdateValue += UpdateValue;

            return AddChild(conditionalBodyProcessor.ProcessBody(conditionalNode.GetBody(), customStackPanel), form);
        }

        #endregion


        public override SymbolTable Register(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;

            return symbolTable;
        }

        private void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
