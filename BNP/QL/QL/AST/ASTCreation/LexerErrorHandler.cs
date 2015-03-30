using System.Collections.Generic;
using Antlr4.Runtime;
using QL.Exceptions;
using QL.Exceptions.Errors;

namespace QL.AST.ASTCreation
{
    public class LexerErrorHandler : IAntlrErrorListener<int>
    {
        private readonly IList<QLBaseException> _lexerErrors;

        public LexerErrorHandler()
        {
            _lexerErrors = new List<QLBaseException>();
        }

        public LexerErrorHandler(IList<QLBaseException> lexerErrors)
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