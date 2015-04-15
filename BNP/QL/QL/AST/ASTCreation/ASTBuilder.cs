using System.Linq;
using Antlr4.Runtime;
using QL.DataHandlers;
using QL.Grammar;

namespace QL.AST.ASTCreation
{
    public class ASTBuilder : IExecutableHandler
    {
        public bool Execute(DataContext context)
        {
            QLLexer lexer = new QLLexer(context.AntlrInput);
            lexer.AddErrorListener(new LexerErrorHandler(context.ASTHandlerExceptions));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);
            parser.AddErrorListener(new ParserErrorHandler(context.ASTHandlerExceptions));

            QLListener listener = new QLListener(context.ASTHandlerExceptions);
            parser.AddParseListener(listener);

            // commence parsing the input as a formBlock since it's supposed to be the entry point of the input file
            parser.formBlock();
            context.RootNode = listener.GetAstRootNode();
            return !context.ASTHandlerExceptions.Any();
        }
    }
}
