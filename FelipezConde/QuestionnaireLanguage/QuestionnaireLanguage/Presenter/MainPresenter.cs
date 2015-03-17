using AST;
using Nodes = AST.Nodes;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.Visitors;
using System.Collections.Generic;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using Types = AST.Types;
using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Events;

namespace QuestionnaireLanguage.Presenter
{
    public class MainPresenter
    {
        private ASTResult astTree;
        private IMainWindow window;
        private SymbolTable symbolTable;
        public EventUpdateValue EventUpdateValue { get; set; }

        public MainPresenter(IMainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            symbolTable = new SymbolTable();
        }

        public UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            BodyProcessor nodeBodyProcessor = new BodyProcessor(symbolTable);
            nodeBodyProcessor.EventUpdateValue += UpdateValue;

            symbolTable = nodeBodyProcessor.Register(symbolTable);

            return nodeBodyProcessor.ProcessBody(body, form);
        }

        public void UpdateValue(string id, Value value)
        {
            symbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.DeleteElements();

            ProcessBody(astTree.Ast.GetBody(), window.GetRootElement());
        }
    }
}
