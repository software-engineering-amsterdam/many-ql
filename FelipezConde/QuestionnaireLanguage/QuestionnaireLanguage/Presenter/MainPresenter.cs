using AST;
using Nodes = AST.Nodes;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using QuestionnaireLanguage.Visitors;
using System.Collections.Generic;
using System.Windows;
using ASTFormObject = AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using Types = AST.Types;
using QuestionnaireLanguage.GUI.FormObject;

namespace QuestionnaireLanguage.Presenter
{
    public class MainPresenter
    {
        private static ASTResult astTree;
        private static IMainWindow window;
        private SymbolTable symbolTable;

        public MainPresenter()
        {}

        public MainPresenter(IMainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            symbolTable = new SymbolTable();
        }

        public UIElement ProcessBody(IList<ASTFormObject.FormObject> body, UIElement form)
        {
            return new BodyProcessor().ProcessBody(body, form);
        }

        public void UpdateValue(string id, Value value)
        {
            symbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.DeleteElements();

            ProcessBody(astTree.Ast.GetBody(), window.GetRootElement());
        }
    }
}
