using AST.Nodes.FormObject;

namespace TypeChecker.Notifications.Errors
{
    public class ComputedQuestionTypeConflict : Error
    {
            private readonly Question node;
            private readonly string typeOfComputedField;
            private readonly string typeOfQuestion;

            public ComputedQuestionTypeConflict(Question node, string typeOfQuestion, string typeOfComputedField)
            {
                this.typeOfComputedField = typeOfComputedField;
                this.node = node;
                this.typeOfQuestion = typeOfQuestion;
            }

            public override string Message()
            {
                return string.Format("Question \"{0}\" at {1} is declared as type {2}, does not match type of computation field ({3})",
                        new string[] {
                            node.Identifier.Name,
                            node.GetPosition().ToString(),
                            typeOfQuestion,
                            typeOfComputedField
                        });
            }
    }
}
