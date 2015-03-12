using AST.Helpers;
using AST.Nodes.FormObject;
using AST.Representation;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecker.Notifications.Errors
{
    public class NonBooleanCondition : Error
    {
            private readonly PositionInText position;

            public NonBooleanCondition(PositionInText position)
            {
                this.position = position;
            }

            public override string Message()
            {
                return string.Format("non-Boolean condition at {0}", position);
            }

            
    }
}
