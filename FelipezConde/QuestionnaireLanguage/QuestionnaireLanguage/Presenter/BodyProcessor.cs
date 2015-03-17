using Evaluation;
using Evaluation.Values;
using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObjects;

namespace QuestionnaireLanguage.Presenter
{
    public class BodyProcessor
    {
        private SymbolTable symbolTable;
        public EventUpdateValue EventUpdateValue { get; set; }

        public BodyProcessor(SymbolTable symbolTable)
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

        private void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }

        internal SymbolTable Register(SymbolTable symbolTable)
        {
            symbolTable = this.symbolTable;
            return symbolTable;
        }
    }
}
