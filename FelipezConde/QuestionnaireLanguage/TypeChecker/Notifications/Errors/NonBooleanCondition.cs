using AST.Representation;

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
