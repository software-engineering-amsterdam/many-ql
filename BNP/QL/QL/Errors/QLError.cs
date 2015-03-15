using System;
using System.Runtime.Serialization;
using QL.Model;

namespace QL.Errors
{
    public class QLError : QLException
    {
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
