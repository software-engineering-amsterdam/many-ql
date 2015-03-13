using AST.Helpers;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Notification.Errors
{
    public class DuplicateIdentifier : IError
    {
            string identifierName;
            IEnumerable<PositionInText> identifierPositions;

            public DuplicateIdentifier(string name, IEnumerable<PositionInText> positions)
            { 
                this.identifierPositions = positions;
                this.identifierName = name;
            }

            public string Message()
            {
                return string.Format("Duplicate identifier \"{0}\" at {1}",
                                      identifierName,
                                      Position.PrettyPrint(identifierPositions));
            }
    }
}
