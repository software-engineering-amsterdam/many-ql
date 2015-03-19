using Notifications;
using System.Collections.Generic;
using AST;

namespace TypeChecking.Notifications.Errors
{
    public class DuplicateIdentifier : Error
    {
            string identifierName;
            PositionInText identifierPosition;

            public DuplicateIdentifier(string name, PositionInText positions)
            { 
                this.identifierPosition = positions;
                this.identifierName = name;
            }

            public override string Message()
            {
                return string.Format("Duplicate identifier \"{0}\" at {1}",
                                      identifierName,
                                      identifierPosition.ToString());
            }
    }
}
