using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Expressions
{
    public class Multiply : BinaryExpression
    {
        public Multiply(IExpression left, IExpression right)
            : base(left, right) { }

        public override string ToString()
        {
            return String.Format("{0} * {1}", Left.ToString(), Right.ToString());
        }
    }
}
