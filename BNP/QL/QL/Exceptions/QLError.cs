using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;


namespace QL.Exceptions
{
    public class QLError : Exception
    {
        public QLError()
        { }

        public QLError(string message)
            : base(message)
        { }

        public QLError(string message, Exception inner)
            : base(message, inner)
        { }

        protected QLError(SerializationInfo info, StreamingContext context)
            : base(info, context)
        { }
    }
}
