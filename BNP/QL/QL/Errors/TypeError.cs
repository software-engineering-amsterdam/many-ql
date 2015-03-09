using System;
using System.Runtime.Serialization;
using QL.Model;

namespace QL.Errors
{
    public class TypeError : QLError
    {
        public SourceLocation SourceLocation { get; private set; }

        public TypeError()
        { }

        public TypeError(string message)  : base(message)
        { }

        public TypeError(string message, ElementBase source)
            : base(message)
        {
            SourceLocation = source.SourceLocation;
        }

        public TypeError(string message, Exception inner)
            : base(message, inner)
        { }

        public override string ToString()
        {
            return string.Format("{0} '{1}' @ {2}", Message, SourceLocation.Source, SourceLocation);
        }
    }
}
