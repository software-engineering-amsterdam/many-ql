using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions
{
    public abstract class BinaryExpression : IExpression
    {
        public IExpression Left
        {
            get;
            private set;
        }

        public IExpression Right
        {
            get;
            private set;
        }

        protected BinaryExpression(IExpression left, IExpression right)
        {
            Left = left;
            Right = right;
        }
    }
}
