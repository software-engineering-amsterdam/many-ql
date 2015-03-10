using System;
using Antlr4.Runtime;
using QL.Errors;
namespace QL.Infrastructure
{
    public class LexerErrorHandler : IAntlrErrorListener<int>
    {
        private System.Collections.Generic.IList<Exception> LexerExceptions;

        public LexerErrorHandler()
        {
            this.LexerExceptions = new System.Collections.Generic.List < Exception >();
        }

        public LexerErrorHandler(System.Collections.Generic.IList<Exception> LexerExceptions)
        {
            this.LexerExceptions = LexerExceptions;
        }
        public void SyntaxError(IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            
            LexerExceptions.Add(new QLError("Error in lexer at line " + line + ":" + charPositionInLine));
        }

    }
}