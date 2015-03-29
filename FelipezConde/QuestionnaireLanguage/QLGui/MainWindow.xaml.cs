using AST;
using Notifications;
using QLGui.Controllers;
using System.Collections.Generic;
using System.Configuration;
using System.Windows;
using WinControls = System.Windows.Controls;
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

            ast = MainTypeChecker.GetTypeCheckDiagnosis(ast);

            controller = new MainController(this, ast);
            controller.CreateMainUIBody();
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

        public void PrintErrorsInGui(INotificationManager notifications)
        {
            IList<INotification> notificationList = notifications.GetNotifications();

            WinControls.Label label = new WinControls.Label()
            {
                Content = "Errors and warnings: " + notificationList.Count
            };
            
            this._stack.Children.Add(label);

            WinControls.ListBox listBox = new WinControls.ListBox();
            listBox.ItemsSource = notificationList;
            this._stack.Children.Add(listBox);

            this.Width = 800;
            this.Height = 600;
        }
    }
}
