using System;
using QL.AST;

namespace QL.Exceptions.Errors
{
    public class ParserError : QLError
    {
        public override string Origin
        {
            get { return "Parser"; }
        }

        public ParserError()
        { }

        public ParserError(string message) : base(message)
        { }

        public ParserError(string message, Exception inner) : base(message, inner)
        { }

        public ParserError(string message, SourceLocation sourceLocation) : base(message)
        {
            SourceLocation = sourceLocation;
        }
    }
}
