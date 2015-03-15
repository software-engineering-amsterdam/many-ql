using System;
using QL.Model;

namespace QL.Exceptions
{
    public class QLWarning : QLException
    {
        /* Base class for all QL Warnings
         */
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