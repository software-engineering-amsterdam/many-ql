using System;
using QL.AST;
using QL.AST.Nodes;

namespace QL.Exceptions.Errors
{
    public class QLError : QLBaseException
    {
        /* Base class for all QL Errors
         */
        public QLError()
        {
        }

        public QLError(string message)
            : base(message)
        { }

        public QLError(string message, SourceLocation sourceLocation)
            : base(message)
        {
            SourceLocation = sourceLocation;
        }

        public QLError(string message, Exception inner)
            : base(message, inner)
        {
        }

        public QLError(string message, ElementBase source)
            : base(message, source)
        {
        }
    }
}
