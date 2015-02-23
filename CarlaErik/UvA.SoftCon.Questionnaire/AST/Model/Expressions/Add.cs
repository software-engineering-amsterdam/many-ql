using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public class Add : BinaryExpression
    {
        public IValue Evaluate(IDictionary<string, IValue> environment)
        {
            IValue left = Left.Evaluate(environment);
            IValue right = Right.Evaluate(environment);

            return left.Add(right);
        }
    }
}
