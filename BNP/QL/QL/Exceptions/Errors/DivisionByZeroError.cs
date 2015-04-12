namespace QL.Exceptions.Errors
{
    public class DivisionByZeroError : QLError
    {
        public override string Origin
        {
            get { return "Division by 0"; }
        }

        public DivisionByZeroError(string message)
            : base(message)
        {
        }

        public DivisionByZeroError()
        {
        }
    }
}