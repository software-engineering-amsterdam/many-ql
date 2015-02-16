using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Numeric
{
    public class DivisionExpression : BinaryNumericExpression
    {
        public DivisionExpression(INumericExpression left, INumericExpression right)
            : base(left, right) { }

        public override int Evaluate()
        {
            if (Right.Evaluate() != 0)
            {
                // As long as we have no float support round to the nearest integer value.
                return (int)Math.Round(Left.Evaluate() / (decimal)Right.Evaluate());
            }
            else
            {
                throw new DivideByZeroException();
            }
        }
    }
}
