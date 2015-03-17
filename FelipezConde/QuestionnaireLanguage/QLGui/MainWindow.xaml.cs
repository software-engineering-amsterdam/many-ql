using AST;
using Notifications;
using QLGui.Controllers;
using System.Configuration;
using System.Windows;
using System.Windows.Input;
using TypeChecking;

namespace QLGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();

            ASTResult ast = new ASTBuilder().BuildAST(ConfigurationManager.AppSettings["inputFile"]);

            if (!ast.NotificationManager.HasError())
            {
                var notificationM1 = TypeChecker.GetTypeCheckDiagnosis(ast);

                //if(!notificationM1.HasError())
                //{ 
                //}
            }
            
            MainController controller = new MainController(this, ast);
            controller.ProcessBody();
            
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
    }
}
