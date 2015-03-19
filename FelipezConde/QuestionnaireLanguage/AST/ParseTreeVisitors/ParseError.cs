using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
