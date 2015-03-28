using Evaluation;
using Evaluation.Values;
using QLGui.ASTVisitors;
using QLGui.FormObjects;
using System.Collections.Generic;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QLGui.Controllers
{
    public class SubController
    {
        private SymbolTable symbolTable;
        public EventUpdateValue EventUpdateValue { get; set; }

        public SubController(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;
        }

        public UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            foreach (ASTFormObject.FormObject node in body)
            {
                FormObject formObject = node.Accept(new FormObjectVisitor());
                formObject.EventUpdateValue += UpdateValue;

                symbolTable = formObject.Register(symbolTable);

                form = formObject.ProcessFormObject(form);
            }

            return form;
        }

        public void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }

        public SymbolTable Register(SymbolTable symbolTable)
        {
            symbolTable = this.symbolTable;
            return symbolTable;
        }
    }
}
