using System;
using System.Collections.Generic;
using Antlr4.Runtime;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Model;

namespace QL.Infrastructure
{
    public class ParserErrorHandler : IAntlrErrorListener<IToken>
    {
        private readonly IList<QLException> _parserErrors;

        public ParserErrorHandler(IList<QLException> parserErrors)
        {
            _parserErrors = parserErrors;
        }

        public ParserErrorHandler()
        {
            _parserErrors = new List<QLException>();
        }

        public void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            ParserError error = new ParserError(msg, new SourceLocation(line, charPositionInLine + 1));
            _parserErrors.Add(error);
        }
    }
}