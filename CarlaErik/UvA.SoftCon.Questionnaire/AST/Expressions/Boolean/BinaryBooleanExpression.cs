using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.Boolean
{
    public abstract class BinaryBooleanExpression<TLeft, TRight> : IBooleanExpression
    {
        public TLeft Left
        {
            get;
            private set;
        }

        public TRight Right
        {
            get;
            private set;
        }

        protected BinaryBooleanExpression(TLeft left, TRight right)
        {
            Left = left;
            Right = right;
        }

        public abstract bool Evaluate();
    }
}
