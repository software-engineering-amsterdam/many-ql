using System;
using System.Runtime.Serialization;
using QL.Model;

namespace QL.Exceptions
{
    public class QLException : Exception
        /* Base class for all QL related exceptions
         */
    {
        public SourceLocation SourceLocation { get; protected set; }

        public virtual string Origin
        {
            get { return GetType().Name; }
        }

        public virtual string Severity
        {
            get
            {
                string typeName = GetType().Name.ToLowerInvariant();
                return typeName.Contains("warning") ? "Warning" : typeName.Contains("error") ? "Error" : "Exception";
            }
        }

        public QLException()
        { }

        public QLException(string message) : base(message)
        { }

        public QLException(string message, ElementBase source) : base(message)
        {
            SourceLocation = source.SourceLocation;
        }

        public QLException(string message, Exception inner) : base(message, inner)
        { }

        public override string ToString()
        {
            return string.Format("{0} '{1}' @ {2}", Message, SourceLocation.Source, SourceLocation);
        }
    }
}