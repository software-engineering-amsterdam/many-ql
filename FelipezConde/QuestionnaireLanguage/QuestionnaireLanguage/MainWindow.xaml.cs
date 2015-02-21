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

namespace QuestionnaireLanguage
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            
            InitializeComponent();

            string path =  @"C:\Users\Daniel\Documents\UVA\Software Construction\Assignments\project\many-ql\FelipezConde\testsamples\";
            string fileName = "test6.txt";

            TestClass test = new TestClass();
            test.GetAST(path + fileName);

            /*FormVisitor visitor = new FormVisitor();
            Console.WriteLine(visitor.Visit(tree));*/
        }
    }
}
