using AST;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Windows;

namespace QLGui.Controllers
{
    public class MainController
    {
        private ASTResult astTree;
        private MainWindow window;
        private SymbolTable symbolTable;

        public MainController(MainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            symbolTable = new SymbolTable();
        }

        public void ProcessBody()
        {
            if (!astTree.HasError())
            {
                SubController BodyProcessor = new SubController(symbolTable);
                              BodyProcessor.EventUpdateValue += UpdateValue;
                              BodyProcessor.ProcessBody(astTree.RootNode.GetBody(), window.GetRootElement());

                              symbolTable = BodyProcessor.SymbolTable;
            }
            else
            {
                window.PrintErrorsInGui(astTree.NotificationManager);
            }
        }

        private void UpdateValue(string id, Value value)
        {
            symbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.DeleteElements();

            ProcessBody();
        }

        public void ExportAnswers()
        {
            ExportFormulaireController exportFormulaire = new ExportFormulaireController();
            exportFormulaire.ExportAnswers(astTree.RootNode.GetBody(), symbolTable);
        }
    }
}
