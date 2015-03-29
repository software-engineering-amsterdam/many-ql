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
        public EventUpdateValue EventUpdateValue { get; set; }

        public MainController(MainWindow mainWindow, ASTResult ast)
        {
            window = mainWindow;
            astTree = ast;

            symbolTable = new SymbolTable();
        }

        public UIElement ProcessBody()
        {
            if (!astTree.HasError())
            {
                SubController nodeBodyProcessor = new SubController(symbolTable);
                nodeBodyProcessor.EventUpdateValue += UpdateValue;

                symbolTable = nodeBodyProcessor.Register(symbolTable);

                return nodeBodyProcessor.ProcessBody(astTree.RootNode.GetBody(), window.GetRootElement());
            }
            else
            {
                
                window.CreateAndShowErrors(GetNotificationMessages());
                return null;
            }
        }

        private IList<string> GetNotificationMessages()
        {
            List<string> result = new List<string>();
            foreach (Notifications.INotification notification in astTree.GetNotifications())
            {
                result.Add(notification.Message());
            }
            return result;
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
