using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Literals
{
    public class DoubleLiteral : Literal<double>, IExpression
    {
        public DoubleLiteral(double value)
            : base(value) { }

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
