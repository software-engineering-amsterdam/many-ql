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
        private SymbolTable symbolTable = new SymbolTable();

        public ConditionalObject(Conditional node)
        {
            this.conditionalNode = node;
        }

        public override StackPanel InsertInUIParent(StackPanel parent)
        {
            Value value = conditionalNode.Condition.Accept(new Evaluator(symbolTable));

            StackPanel customStackPanel = value.Accept(new ValueToStackPanel());

            SubController conditionalController = new SubController(symbolTable);
            conditionalController.EventUpdateValue += base.EventUpdateValue;

            parent.Children.Add(
                conditionalController.CreateUIBody(conditionalNode.GetBody(), customStackPanel));

            return parent;
        }

        public override SymbolTable RegisterInSymbolTable(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;
            return symbolTable;
        }
    }
}
