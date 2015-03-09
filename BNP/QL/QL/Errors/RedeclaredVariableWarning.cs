using System;

namespace QL.Errors
{
    public class RedeclaredVariableWarning : QLWarning
    {
        public RedeclaredVariableWarning(string message) : base(message)
        {
        }
    }
}
