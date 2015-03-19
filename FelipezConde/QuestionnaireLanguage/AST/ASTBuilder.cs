using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Nodes;
using AST.ParseTreeVisitors;
using Grammar;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

            parser.RemoveErrorListeners();
            ParserErrorListener parseErrorListener = new ParserErrorListener();
            parser.AddErrorListener(parseErrorListener);

            FormVisitor visitor = new FormVisitor();
            Form ast = visitor.Visit(parser.form());

            return new ASTResult(ast, parseErrorListener.NotificationManager);
        }
    }
}
