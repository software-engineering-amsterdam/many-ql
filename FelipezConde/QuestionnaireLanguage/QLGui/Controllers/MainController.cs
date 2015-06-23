using AST;
using AST.Nodes.Expressions;
using Evaluation;
using Evaluation.Values;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.Controllers
{
    public class MainController
    {
        private readonly ASTResult astTree;
        private readonly MainWindow window;
        private SymbolTable symbolTable = new SymbolTable();

        public MainController(MainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;
        }

        public void CreateMainUIBody()
        {
            if (!astTree.HasError())
            {
                SubController bodyController = new SubController(symbolTable, UpdateValue);
                bodyController.CreateUIBody(astTree.RootNode, (StackPanel)window.GetRootElement()); //Defined in XML, so object has to be casted
                symbolTable = bodyController.SymbolTable;
            }
            else
            {
                window.PrintErrorsInGui(astTree.NotificationManager);
            }
        }

        //this method is passed along as a delegate to the subcontroller
        private void UpdateValue(string id, Value value)
        {
            symbolTable.SetUpdateValue(new Id(id, new PositionInText()), value);

            window.Invalidate();
            CreateMainUIBody();
        }

        public void ExportAnswers()
        {
            new ExportFormulaireController()
                .ExportAnswers(astTree.RootNode, symbolTable);
        }
    }
}
