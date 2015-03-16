using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Nodes;
using AST.ParseTreeVisitors;
using Grammar;
using System;
using System.IO;

namespace AST.Test
{
    public class TestClass
    {
        public TestClass(){}

        public ASTResult GetAST(string path)
        {
            string program = File.ReadAllText(path);

            AntlrInputStream input = new AntlrInputStream(program);
            QLMainLexer lexer = new QLMainLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLMainParser parser = new QLMainParser(tokens);

            parser.RemoveErrorListeners();
            parser.AddErrorListener(new ParserErrorListener());

            IParseTree tree = parser.form();

            Console.WriteLine(tree.ToStringTree(parser));
            FormVisitor visitor = new FormVisitor();
            Form ast = visitor.Visit(tree);

            return new ASTResult(ast);
        }
    }
}
