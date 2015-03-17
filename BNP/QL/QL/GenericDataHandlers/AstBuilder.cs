using Antlr4.Runtime;
using QL.Grammars;
using QL.Infrastructure;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.GenericDataHandlers
{
    class AstBuilder :IExecutable
    {
        public AstBuilder(){}
        public bool execute(DataContext context)
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
