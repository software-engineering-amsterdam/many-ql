using AST;
using Notifications;
using QLGui.Controllers;
using System.Collections.Generic;
using System.Configuration;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using TypeChecking;

namespace QLGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private MainController controller;

        public MainWindow()
        {
            InitializeComponent();

            ASTResult ast = new ASTBuilder().BuildAST(ConfigurationManager.AppSettings["inputFile"]);

            if (!ast.HasError())
            {
                ast = TypeChecker.GetTypeCheckDiagnosis(ast);

                controller = new MainController(this, ast);
                controller.ProcessBody();
            }
        }

        public UIElement GetRootElement()
        {
            return this._stack;
        }

        public void DeleteElements()
        {
            this._stack.Children.Clear();
        }
        private void Grid_MouseDown(object sender, MouseButtonEventArgs e)
        {
            Keyboard.ClearFocus();
        }

        private void ExportAnswers_Click(object sender, RoutedEventArgs e)
        {
            controller.ExportAnswers();
        }

        public void CreateAndAddErrorList(IList<INotification> notifications)
        {
            ListBox listBox = new ListBox();
            listBox.ItemsSource = notifications;

            this._stack.Children.Add(listBox);
        }
    }
}
