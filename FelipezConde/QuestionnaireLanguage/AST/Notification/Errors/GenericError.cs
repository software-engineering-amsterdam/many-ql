using AST.Helpers;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Notification.Errors
{
    public class GenericError : IError
    {
            PositionInText position;

            public GenericError(PositionInText position)
            { this.position = position; }

            public string Message()
            {
                return "A generic error occurred at" +
                       Position.PrettyPrint(position);
            }

            
    }
}
