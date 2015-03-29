using AST.Nodes.Expressions.Unaries;
using Types = AST.Types;

namespace TypeChecking.Notifications.Errors
{
    public class IncompatibleUnaryOperator : Error
    {
        private readonly Unary node;
        private readonly Types.Type childType;

        public IncompatibleUnaryOperator(Unary node, Types.Type childType)
        {
            this.node = node;
            this.childType = childType;
        }

        public override string Message()
        {
            return string.Format("Operator \"{0}\" is incompatible with type \"{1}\" at {2}",
                    new object[] {
                        node,
                        childType,
                        node.GetPosition()
                    });
        }
    }
}
