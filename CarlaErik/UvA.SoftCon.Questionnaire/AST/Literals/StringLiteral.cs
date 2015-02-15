using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.String;

namespace UvA.SoftCon.Questionnaire.AST.Literals
{
    /// <summary>
    /// Represents a static immutable string value.
    /// </summary>
    public class StringLiteral : Literal<string>, IStringExpression
    {
        public StringLiteral(string value)
            : base(value) { }

        public string Evaluate()
        {
            return Value;
        }
    }
}
