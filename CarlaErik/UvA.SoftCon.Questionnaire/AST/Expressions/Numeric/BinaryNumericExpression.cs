using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Numeric
{
    public abstract class BinaryNumericExpression : INumericExpression
    {
        public INumericExpression Left
        {
            get;
            private set;
        }

        public INumericExpression Right
        {
            get;
            private set;
        }

        protected BinaryNumericExpression(INumericExpression left, INumericExpression right)
        {
            Left = left;
            Right = right;
        }

        public abstract int Evaluate();
    }
}
