using AST.Helpers;
using AST.Representation;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecker.Notifications.Errors
{
    public class UndefinedIdentifier : Error
    {
            private readonly PositionInText position;
            private readonly string name;

            public UndefinedIdentifier(PositionInText position, string name)
            { 
                this.position = position;
                this.name = name;
            }
            public override string Message()
            {
                return string.Format("Undefined identifier \"{0}\" at {1}",
                                      name,
                                      Position.PrettyPrint(position));
            }               
    }
}
