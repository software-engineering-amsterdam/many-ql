using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions.String
{
    public class ConcatinationExpression : IStringExpression
    {
        public IStringExpression Left
        {
            get;
            private set;
        }

        public IStringExpression Right
        {
            get;
            private set;
        }

        public ConcatinationExpression(IStringExpression left, IStringExpression right)
        {
            Left = left;
            Right = right;
        }

        public string Evaluate()
        {
            return System.String.Concat(Left, Right);
        }
    }
}
