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
        private ASTResult astTree;
        private MainWindow window;
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
                SubController BodyController = new SubController(symbolTable);
                              BodyController.EventUpdateValue += UpdateValue; //when the subController updates, update this as well.
                              BodyController.CreateUIBody(
                                    astTree.RootNode.GetBody(), 
                                    (StackPanel)window.GetRootElement() //Defined in XML, so has to be casted
                              );

                              symbolTable = BodyController.SymbolTable;
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
            CreateMainUIBody();
        }

        public void ExportAnswers()
        {
            new ExportFormulaireController()
                .ExportAnswers(astTree.RootNode.GetBody(), symbolTable);
        }
    }
}
