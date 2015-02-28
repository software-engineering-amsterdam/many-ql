using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Exceptions
{
    public class TypeException : QLException
    {
        public TypeException() { }
        public TypeException(string message) : base(message) { }
        public TypeException(string message, Exception inner) : base(message, inner) { }
        protected TypeException(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }


    }
}
    