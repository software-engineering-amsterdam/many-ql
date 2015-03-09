using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Checks whether literal values are valid within the bounds of their types.
    /// </summary>
    public class LiteralCheckingVisitor : QLVisitor
    {
        public ICollection<Literal> InvalidLiterals
        {
            get;
            private set;
        }

        public LiteralCheckingVisitor()
        {
            InvalidLiterals = new List<Literal>();
        }

        public override void Visit(IntegerLiteral literal)
        {
            if (!literal.IsValid)
            {
                InvalidLiterals.Add(literal);
            }
        }

        public override void Visit(DateLiteral literal)
        {
            if (literal.IsValid)
            {
                InvalidLiterals.Add(literal);
            }
        }
    }
}
