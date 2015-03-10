using AST.Helpers;
using AST.Nodes.FormObject;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Notification.Errors
{
    public class NonBooleanCondition : IError
    {
            private readonly PositionInText position;

            public NonBooleanCondition(PositionInText position)
            {
                this.position = position;
            }

            public string Message()
            {
                return string.Format("non-Boolean condition at {0}", position);
            }

            
    }
}
