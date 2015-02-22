using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    /// <summary>
    /// Represents a static, immutable string value.
    /// </summary>
    public class StringLiteral : Literal<string>
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.StringLiteral;
            }
        }

        public StringLiteral(string value, TextPosition position)
            : base(value, position) { }

        public override string ToString()
        {
            return '"' + Value + '"';
        }
    }
}
