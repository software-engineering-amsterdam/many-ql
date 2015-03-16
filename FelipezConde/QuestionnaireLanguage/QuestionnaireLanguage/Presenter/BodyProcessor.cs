using Evaluation;
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

        public BodyProcessor()
        {
            symbolTable = new SymbolTable();
        }

        public UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            foreach (ASTFormObject.FormObject node in body)
            {
                FormObject formObject = new FormObjectVisitor().VisitFormObject(node);
                symbolTable = formObject.Register(symbolTable);

                form = formObject.ProcessFormObject(form);
            }

            return form;
        }
    }
}
