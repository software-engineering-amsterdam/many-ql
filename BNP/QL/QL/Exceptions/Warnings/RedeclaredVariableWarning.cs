using QL.AST;

namespace QL.Exceptions.Warnings
{
    public class RedeclaredVariableWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Redeclared var"; }
        }

        public RedeclaredVariableWarning(string message)
            : base(message)
        {
        }

        public RedeclaredVariableWarning(string message, SourceLocation source)
            : base(message, source)
        {
        }
    }
}
