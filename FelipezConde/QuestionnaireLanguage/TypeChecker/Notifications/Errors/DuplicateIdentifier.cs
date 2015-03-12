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
    public class DuplicateIdentifier : Error
    {
            string identifierName;
            IEnumerable<PositionInText> identifierPositions;

            public DuplicateIdentifier(string name, IEnumerable<PositionInText> positions)
            { 
                this.identifierPositions = positions;
                this.identifierName = name;
            }

            public override string Message()
            {
                return string.Format("Duplicate identifier \"{0}\" at {1}",
                                      identifierName,
                                      Position.PrettyPrint(identifierPositions));
            }
    }
}
