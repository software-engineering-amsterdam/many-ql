using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Boolean
{
    public class GreaterThanExpression : BinaryBooleanExpression<INumericExpression, INumericExpression>
    {
        public GreaterThanExpression(INumericExpression left, INumericExpression right)
            : base(left, right) { }

        public override bool Evaluate()
        {
            return Left.Evaluate() > Right.Evaluate();
        }
    }
}
