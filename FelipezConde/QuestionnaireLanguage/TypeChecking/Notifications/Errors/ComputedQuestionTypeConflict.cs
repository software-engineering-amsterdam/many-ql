using AST.Nodes.FormObjects;
using Types = AST.Types;

namespace TypeChecking.Notifications.Errors
{
    public class ComputedQuestionTypeConflict : Error
    {
            private readonly Question node;
            private readonly Types.Type typeOfComputedField;

            public ComputedQuestionTypeConflict(Question node, Types.Type typeOfComputedField)
            {
                this.node = node;
                this.typeOfComputedField = typeOfComputedField;
            }

            public override string Message()
            {
                return string.Format("Question \"{0}\" at {1} is declared as type {2}, does not match type of computation field ({3})",
                        new object[] {
                            node.Identifier.Name,
                            node.GetPosition(),
                            node.RetrieveType(),
                            typeOfComputedField
                        });
            }
    }
}
