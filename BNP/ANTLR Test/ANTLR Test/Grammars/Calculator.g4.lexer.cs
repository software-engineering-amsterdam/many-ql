using System;
using Antlr4.Runtime;

namespace ANTLR_Test.Grammars
{
    partial class CalculatorLexer
    {

        public void AddErrorHandlers()
        {
            this.AddErrorListener(new ErrorHandler());
        }
    }

    public class ErrorHandler : IAntlrErrorListener<int>
    {
        public void SyntaxError(IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Console.WriteLine("Error in lexer at line " + line + ":" + charPositionInLine);
        }
    }
}
