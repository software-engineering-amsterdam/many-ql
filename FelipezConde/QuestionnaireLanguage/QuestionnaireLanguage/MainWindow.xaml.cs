using Antlr4.Runtime;
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
using GrammarProject;
using Antlr4.Runtime.Tree;
using System.IO;
using QuestionnaireLanguage.AST;

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

            string program = 
            File.ReadAllText(
            @"C:\Users\Daniel\Documents\UVA\Software Construction\Assignments\project\many-ql\FelipezConde\testsamples\test9.txt");
            //Console.WriteLine(program);

            AntlrInputStream input = new AntlrInputStream(program);
            QLMainLexer lexer = new QLMainLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLMainParser parser = new QLMainParser(tokens);
            IParseTree tree = parser.form();



            Console.WriteLine(tree.ToStringTree(parser));
            QLMainVisitor visitor = new QLMainVisitor();
            iASTNode ast = visitor.Visit(tree);

            /*FormVisitor visitor = new FormVisitor();
            Console.WriteLine(visitor.Visit(tree));*/
        }
    }
}
