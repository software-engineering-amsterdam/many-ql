using AST;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using Types = AST.Types;

namespace TypeChecking.Notifications.Errors
{
    public class IncompatibleBinaryOperator : Error
    {
            private readonly Binary node;
            private readonly Types.Type leftType;
            private readonly Types.Type rightType;

            public IncompatibleBinaryOperator(Binary node, Types.Type leftType, Types.Type rightType)
            {
                this.node = node;
                this.rightType = rightType;
                this.leftType = leftType;
            }

            public override string Message()
            {
                return string.Format("Operator \"{0}\" is incompatible with types \"{1}\" and \"{2}\" at {3}",
                        new object[] {
                            node,
                            leftType,
                            rightType,
                            node.GetPosition()
                        });
            }

            
    }
}
