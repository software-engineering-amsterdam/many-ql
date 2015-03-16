using AST;
using AST.Test;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.Controller;
using System.Windows;

namespace QuestionnaireLanguage
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, IMainWindow
    {
        public MainWindow()
        {
            InitializeComponent();

            string path = @"C:\Users\Daniel\Documents\UVA\Software Construction\Assignments\project\many-ql\FelipezConde\testsamples\";
            //string path =  @"C:\Users\Jonatan\Desktop\Software Construction\QL Assignment\many-ql\FelipezConde\testsamples\";
            string fileName = "test9.txt";

            TestClass test = new TestClass();
            ASTResult ast = test.GetAST(path + fileName);

            MainController procesor = new MainController(this, ast);
            MainController.ProcessBody(ast.Ast.GetBody(), this._stack);
        }

        public UIElement GetRootElement()
        {
            return this._stack;
        }

        public void DeleteElements()
        {
            this._stack.Children.Clear();
        }
    }
}
