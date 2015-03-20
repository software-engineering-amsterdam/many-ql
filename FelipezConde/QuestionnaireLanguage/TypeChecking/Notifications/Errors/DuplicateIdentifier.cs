﻿using Notifications;
using System.Collections.Generic;
using AST;

namespace TypeChecking.Notifications.Errors
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
                                      PositionPrinter.PrettyPrint(identifierPositions));
            }
    }
}