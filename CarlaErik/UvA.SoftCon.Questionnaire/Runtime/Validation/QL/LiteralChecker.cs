using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks whether literal values are valid within the bounds of their types.
    /// </summary>
    public class LiteralChecker : QLVisitor<object>
    {
        public ICollection<Literal> InvalidLiterals
        {
            get;
            private set;
        }

        public LiteralChecker()
        {
            InvalidLiterals = new List<Literal>();
        }

        public override object Visit(IntegerLiteral literal)
        {
            if (!literal.IsValid)
            {
                InvalidLiterals.Add(literal);
            }
            return null;
        }

        public override object Visit(DateLiteral literal)
        {
            if (!literal.IsValid)
            {
                InvalidLiterals.Add(literal);
            }
            return null;
        }
    }
}
