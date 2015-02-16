using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Numeric
{
    public class MultiplyExpression : BinaryNumericExpression
    {
        public MultiplyExpression(INumericExpression left, INumericExpression right)
            : base(left, right) { }

        public override int Evaluate()
        {
            return Left.Evaluate() * Right.Evaluate();
        }
    }
}
