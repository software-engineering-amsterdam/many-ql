namespace QL.Errors
{
    public class QLWarning : QLException
    {
        protected QLWarning(string message) : base(message)
        {
        }
    }
}