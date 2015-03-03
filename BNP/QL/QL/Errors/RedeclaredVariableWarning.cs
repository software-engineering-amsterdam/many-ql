using System;

namespace QL.Errors
{
    public class RedeclaredVariableWarning : QLError
    {
        public RedeclaredVariableWarning() { }
        public RedeclaredVariableWarning(string message) : base(message) { }
        public RedeclaredVariableWarning(string message, Exception inner) : base(message, inner) { }
        protected RedeclaredVariableWarning(
          System.Runtime.Serialization.SerializationInfo info,
          System.Runtime.Serialization.StreamingContext context)
            : base(info, context) { }
    }
}
