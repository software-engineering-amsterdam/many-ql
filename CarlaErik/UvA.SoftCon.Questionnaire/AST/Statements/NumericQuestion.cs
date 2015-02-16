using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;

namespace UvA.SoftCon.Questionnaire.AST.Statements
{
    /// <summary>
    /// Represents a question which requires a numeral answer.
    /// </summary>
    public class NumericQuestion : Question, INumericExpression
    {
        public NumericQuestion(string id, string label)
            : base(id, label) { }

        public int Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}
