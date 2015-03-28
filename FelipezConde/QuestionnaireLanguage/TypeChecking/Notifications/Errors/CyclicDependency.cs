using Notifications;
using System.Collections.Generic;
using AST;
using AST.Nodes.Expressions;

namespace TypeChecking.Notifications.Errors
{
    public class CyclicDependency : Error
    {
            Id id;
            PositionInText identifierPosition;

            public CyclicDependency(Id id)
            {
                this.id = id;
            }

            public override string Message()
            {
                return string.Format("Cyclic dependency for identifier \"{0}\" at {1}",
                                      id.Name,
                                      id.GetPosition().ToString());
            }
    }
}
