using System;
using System.Runtime.Serialization;

namespace QL.Errors
{
    public class QLError : QLException
    {
        public QLError()
        {
        }

        public QLError(string message) : base(message)
        {
        }

        public QLError(string message, Exception inner) : base(message, inner)
        {
        }
    }
}
