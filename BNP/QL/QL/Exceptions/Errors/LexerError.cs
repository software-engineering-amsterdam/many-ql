using System;
using QL.AST;

namespace QL.Exceptions.Errors
{
    public class LexerError : QLError
    {
        public override string Origin
        {
            get { return "Lexer"; }
        }

        public LexerError()
        { }

        public LexerError(string message) : base(message)
        { }

        public LexerError(string message, Exception inner) : base(message, inner)
        { }

        public LexerError(string message, SourceLocation sourceLocation) : base(message)
        {
            SourceLocation = sourceLocation;
        }
    }
}