using System;

namespace QL.Errors
{
    public class RedeclaredVariableWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Redeclared var"; }
        }

        public RedeclaredVariableWarning(string message) : base(message)
        {
        }
    }
}
