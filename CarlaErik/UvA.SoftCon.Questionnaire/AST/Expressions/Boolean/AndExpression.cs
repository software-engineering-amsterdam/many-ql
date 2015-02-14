using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Boolean
{
    public class AndExpression : BinaryBooleanExpression<IBooleanExpression, IBooleanExpression>
    {
        public AndExpression(IBooleanExpression left, IBooleanExpression right)
            : base(left, right) { }

        public override bool Evaluate()
        {
            return Left.Evaluate() && Right.Evaluate();
        }
    }
}
