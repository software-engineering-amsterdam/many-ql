using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;

namespace UvA.SoftCon.Questionnaire.AST.Identifiers
{
    public class NumericIdentifier : Identifier, INumericExpression
    {
        public NumericIdentifier(string name)
            : base(name) { }

        public int Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}
