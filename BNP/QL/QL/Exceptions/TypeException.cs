using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;
using QL.Model;

namespace QL.Exceptions
{
    public class TypeException : QLException
    {
        public SourceLocation SourceLocation { get; private set; }

        public TypeException()
        { }

        public TypeException(string message, ElementBase source)
            : base(message)
        {
            SourceLocation = source.SourceLocation;
        }

        public TypeException(string message, Exception inner)
            : base(message, inner)
        { }

        protected TypeException(SerializationInfo info, StreamingContext context)
            : base(info, context)
        { }

        public override string ToString()
        {
            return string.Format("{0} '{1}' @ {2}", Message, SourceLocation.Source, SourceLocation);
        }
    }
}
