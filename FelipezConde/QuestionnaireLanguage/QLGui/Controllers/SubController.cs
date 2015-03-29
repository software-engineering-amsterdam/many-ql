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
        public SymbolTable SymbolTable { get; private set; }
        public EventUpdateValue EventUpdateValue { get; set; }

        public SubController(SymbolTable symbolTable)
        {
            this.SymbolTable = symbolTable;
        }

        public UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            foreach (ASTFormObject.FormObject node in body)
            {
                FormObject formObject = node.Accept(new FormObjectVisitor());
                formObject.EventUpdateValue += UpdateValue;

                SymbolTable = formObject.Register(SymbolTable);

                form = formObject.ProcessFormObject(form);
            }

            return form;
        }

        public void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
