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
    public class IncompatibleUnaryOperator : Error
    {
            private readonly PositionInText position;
            private readonly string op;
            private readonly string childType;

            public IncompatibleUnaryOperator(PositionInText position, string op, string childType)
            {
                this.op = op;
                this.childType = childType;
                this.position = position;
            }

            public override string Message()
            {
                return string.Format("Operator \"{0}\" is incompatible with type \"{1}\" at {2}",
                        new string[] {
                            op,
                            childType,
                            Position.PrettyPrint(position)
                        });
            }

            
    }
}
