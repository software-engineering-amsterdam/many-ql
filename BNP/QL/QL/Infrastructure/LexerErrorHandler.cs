using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using QL.Errors;
using QL.Model;

namespace QL.Infrastructure
{
    public class LexerErrorHandler : IAntlrErrorListener<int>
    {
        private readonly IList<QLException> _lexerErrors;

        public LexerErrorHandler()
        {
            _lexerErrors = new List<QLException>();
        }

        public LexerErrorHandler(IList<QLException> lexerErrors)
        {
            _lexerErrors = lexerErrors;
        }

        public void SyntaxError(IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            LexerError error = new LexerError(msg, new SourceLocation(line, charPositionInLine + 1));
            _lexerErrors.Add(error);
        }

    }
}