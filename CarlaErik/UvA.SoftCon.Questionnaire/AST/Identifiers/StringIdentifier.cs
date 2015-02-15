using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.String;

namespace UvA.SoftCon.Questionnaire.AST.Identifiers
{
    public class StringIdentifier : Identifier, IStringExpression
    {
        public StringIdentifier(string name)
            : base(name)
        {
        }

        public string Evaluate()
        {
            throw new NotImplementedException();
        }
    }
}
