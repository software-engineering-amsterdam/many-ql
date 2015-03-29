using Evaluation;
using Evaluation.Values;
using QLGui.ASTVisitors;
using QLGui.FormObjects;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QLGui.Controllers
{
    public class SubController
    {
        public SymbolTable SymbolTable { get; private set; }
        public EventUpdateValue EventUpdateValue { get; set; }

        public SubController(SymbolTable symbolTable)
        {
            this.SymbolTable = symbolTable;
        }

        public StackPanel CreateUIBody(IList<ASTFormObject.FormObject> body, StackPanel parent)
        {
            foreach (ASTFormObject.FormObject node in body)
            {
                FormObject formObject = node.Accept(new FormObjectVisitor());
                formObject.EventUpdateValue += UpdateValue;

                SymbolTable = formObject.RegisterInSymbolTable(SymbolTable);

                parent = formObject.InsertInUIParent(parent);
            }

            return parent;
        }

        public void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
