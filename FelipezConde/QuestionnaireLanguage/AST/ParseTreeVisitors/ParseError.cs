using Notifications;

namespace AST.ParseTreeVisitors
{
    public class ParseError : INotification
    {
        private string errorDescription;

        public ParseError(string errorDescription)
        {
            this.errorDescription = errorDescription;
        }
    
        public string Message()
        {
            return errorDescription;
        }

        public bool IsError()
        {
            return true;
        }
    }
}
