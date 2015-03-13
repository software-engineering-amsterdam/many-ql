using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;
using AST;
using AST.Test;
using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.Contracts;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel;

namespace QuestionnaireLanguage
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, IMain
    {
        public MainWindow()
        {
            InitializeComponent();

            string path =  @"C:\Users\Daniel\Documents\UVA\Software Construction\Assignments\project\many-ql\FelipezConde\testsamples\";
            string fileName = "test9.txt";

            TestClass test = new TestClass();
            ASTResult ast = test.GetAST(path + fileName);

            Processor procesor = new Processor(this, ast);
            UIElement element = Processor.ProcessBody(ast.Ast.GetBody(), this._stack);
        }

        public UIElementCollection GetControls()
        {
            return this._stack.Children;
        }

        public void AddControl(UIElement element)
        {
            this._stack.Children.Add(element);
        }

        public UIElement GetRootElement()
        {
            return this._stack;
        }

        public void DeleteElements()
        {
            this._stack.Children.Clear();
        }

        public void SetFocus(IInputElement inputElement)
        {
            Keyboard.Focus(inputElement);
        }
    }
}
