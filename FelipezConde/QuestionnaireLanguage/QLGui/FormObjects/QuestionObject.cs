using AST.Nodes.FormObjects;
using Evaluation;
using Evaluation.Values;
using QLGui.ASTVisitors;
using QLGui.ValueVisitors;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.FormObjects
{
    public class QuestionObject : FormObject
    {
        private Question questionNode;
        private SymbolTable symbolTable = new SymbolTable();

        public QuestionObject(Question node)
        {
            this.questionNode = node;
        }
        public override StackPanel InsertInUIParent(StackPanel parent)
        {
            parent.Children.Add(
                new Label() { Content = questionNode.Label.ToString() }
                );

            Value widgetValue = this.Evaluate();
            
            ValueToUIElement valueToUIElement = new ValueToUIElement(questionNode.Identifier.Name, questionNode.Computation != null);
            valueToUIElement.EventUpdateValue += base.EventUpdateValue;

            parent.Children.Add(widgetValue.Accept(valueToUIElement));

            return parent;
        }

        public Value Evaluate()
        {
            if (questionNode.Computation != null)
            {
                return questionNode.Computation.Accept(new Evaluator(symbolTable));
            }
            return symbolTable.GetValue(questionNode.Identifier);
        }

        public override SymbolTable RegisterInSymbolTable(SymbolTable symbolTable)
        {
            TypeToValue visitor = new TypeToValue();
            symbolTable.AddValue(questionNode.Identifier, questionNode.RetrieveType().Accept(new TypeToValue()));

            this.symbolTable = symbolTable;
            
            return symbolTable;
        }
    }
}
