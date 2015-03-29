using AST;

namespace TypeChecking.Notifications.Errors
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
                return string.Format("Non-Boolean condition at {0}", position);
            }

            
    }
}
