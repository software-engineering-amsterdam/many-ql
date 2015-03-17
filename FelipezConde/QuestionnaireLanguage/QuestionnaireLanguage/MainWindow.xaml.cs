using AST;
using AST.Test;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.Presenter;
using System.Windows;
using System.Windows.Input;

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
            string fileName = "demo.txt";

            TestClass test = new TestClass();
            ASTResult ast = test.GetAST(path + fileName);

            MainPresenter procesor = new MainPresenter(this, ast);
            procesor.ProcessBody(ast.Ast.GetBody(), this._stack);
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
