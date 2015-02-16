using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    /// <summary>
    /// Represents a question which requires a yes/no answer.
    /// </summary>
    public class BooleanQuestion : Question, IBooleanExpression
    {
        public BooleanQuestion(string id, string label)
            : base(id, label)
        {
        }

        public bool Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}
