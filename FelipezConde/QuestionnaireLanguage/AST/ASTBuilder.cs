using Antlr4.Runtime;
using AST.Nodes;
using AST.ParseTreeVisitors;
using Grammar;
using System.IO;

namespace AST
{
    public class ASTBuilder
    {
        public ASTBuilder() { }

        public ASTResult BuildAST(string filePath)
        {
            string programText = File.ReadAllText(filePath);

            QLMainParser parser = new QLMainParser(
                new CommonTokenStream(
                    new QLMainLexer(
                        new AntlrInputStream(programText)
                        )));

            ParserErrorListener parseErrorListener = new ParserErrorListener();
            parser.RemoveErrorListeners();
            parser.AddErrorListener(new ParserErrorListener());

            Form ast = new FormVisitor().Visit(parser.form());

            return new ASTResult(ast, parseErrorListener.NotificationManager);
        }
    }
}
