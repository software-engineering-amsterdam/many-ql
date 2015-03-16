using AST.Representation;

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
                            position.ToString()
                        });
            }

            
    }
}
