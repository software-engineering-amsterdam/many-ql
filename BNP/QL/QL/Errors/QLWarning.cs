using System;
using QL.Model;

namespace QL.Errors
{
    public class QLWarning : QLException
    {
        public QLWarning()
        {
        }

        public QLWarning(string message)
            : base(message)
        {
        }

        public QLWarning(string message, Exception inner)
            : base(message, inner)
        {
        }

        public QLWarning(string message, ElementBase source)
            : base(message, source)
        {
        }
    }
}