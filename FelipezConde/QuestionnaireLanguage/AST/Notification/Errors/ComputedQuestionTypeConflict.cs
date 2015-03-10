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
    public class ComputedQuestionTypeConflict : IError
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

            public string Message()
            {
                return string.Format("Question \"{0}\" at {1} is declared as type {2}, does not match type of computation field ({3})",
                        new string[] {
                            node.Identifier.Name,
                            Position.PrettyPrint(node.GetPosition()),
                            typeOfQuestion,
                            typeOfComputedField
                        });


            }

            
    }
}
