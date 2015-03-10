using System;
using System.Runtime.Serialization;

namespace QL.Errors
{
    public class QLException : Exception
    {
        public QLException()
        { }

        public QLException(string message)
            : base(message)
        { }

        public QLException(string message, Exception inner)
            : base(message, inner)
        { }

        protected QLException(SerializationInfo info, StreamingContext context)
            : base(info, context)
        { }
    }
}