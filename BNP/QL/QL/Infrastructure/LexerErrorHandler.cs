using System;
using Antlr4.Runtime;

namespace QL.Infrastructure
{
    public class LexerErrorHandler : IAntlrErrorListener<int>
    {
        public void SyntaxError(IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Console.WriteLine("Error in lexer at line " + line + ":" + charPositionInLine);
        }
    }
}