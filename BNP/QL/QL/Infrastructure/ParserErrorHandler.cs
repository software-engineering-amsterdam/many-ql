using System;
using Antlr4.Runtime;
using QL.Errors;

namespace QL.Infrastructure
{
    public class ParserErrorHandler : IAntlrErrorListener<IToken>
    {
        private System.Collections.Generic.IList<Exception> ParserExceptions;

        public ParserErrorHandler(System.Collections.Generic.IList<Exception> ParserExceptions)
        {
            this.ParserExceptions = ParserExceptions;
        }
        public ParserErrorHandler()
        {
            this.ParserExceptions = new System.Collections.Generic.List<Exception>();
        }
        public void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            ParserExceptions.Add(new QLError("Error in parser at line " + line + ":" + charPositionInLine));
        }
    }
}