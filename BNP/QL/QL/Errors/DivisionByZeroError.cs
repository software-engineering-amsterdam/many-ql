namespace QL.Errors
{
    public class DivisionByZeroError : QLError
    {
        public DivisionByZeroError(string message) : base(message)
        {
        }
    }
}