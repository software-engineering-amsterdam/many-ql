using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Nodes.Interfaces;
using AST.ParseTreeVisitors;
using Grammar;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Test
{
    public class TestClass
    {
        public TestClass()
        {

        }

        public IASTNode GetAST(string path)
        {
            string program = File.ReadAllText(path);

            AntlrInputStream input = new AntlrInputStream(program);
            QLMainLexer lexer = new QLMainLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLMainParser parser = new QLMainParser(tokens);
            IParseTree tree = parser.form();

            Console.WriteLine(tree.ToStringTree(parser));
            MainVisitor visitor = new MainVisitor();
            IASTNode ast = visitor.Visit(tree);

            return ast;
        }
    }
}
