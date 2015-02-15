using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Boolean
{
    public class NumericEqualsExpression : BinaryBooleanExpression<INumericExpression, INumericExpression>
    {
        public NumericEqualsExpression(INumericExpression left, INumericExpression right)
            : base(left, right) { }

        public override bool Evaluate()
        {
            return Left.Evaluate() == Right.Evaluate();
        }
    }
}
