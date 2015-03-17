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
        private readonly IList<QLBaseException> _parserErrors;

        public ParserErrorHandler(IList<QLBaseException> parserErrors)
        {
            _parserErrors = parserErrors;
        }

        public ParserErrorHandler()
        {
            _parserErrors = new List<QLBaseException>();
        }

        public void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            ParserError error = new ParserError(msg, new SourceLocation(line, charPositionInLine + 1));
            _parserErrors.Add(error);
        }
    }
}