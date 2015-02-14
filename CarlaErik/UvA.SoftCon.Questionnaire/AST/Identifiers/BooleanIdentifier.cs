using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;

namespace UvA.SoftCon.Questionnaire.AST.Identifiers
{
    public class BooleanIdentifier : Identifier, IBooleanExpression
    {
        public BooleanIdentifier(string name)
            : base(name)
        {
        }

        public bool Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}
