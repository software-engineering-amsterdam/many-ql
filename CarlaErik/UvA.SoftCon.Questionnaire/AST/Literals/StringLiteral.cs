using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Literals
{
    /// <summary>
    /// Represents a static immutable string value.
    /// </summary>
    public class StringLiteral : Literal<string>, IExpression
    {
        public StringLiteral(string value)
            : base(value) { }
    }
}
