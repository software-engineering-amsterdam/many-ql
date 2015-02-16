using System;
using Antlr4.Runtime;

namespace QL.Infrastructure
{
    public class ParserErrorHandler : IAntlrErrorListener<IToken>
    {
        public void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Console.WriteLine("Error in lexer at line " + line + ":" + charPositionInLine);
        }
    }
}