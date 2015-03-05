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
    public class LiteralCheckingVisitor : QLVisitor
    {
        public ICollection<DateLiteral> InvalidDateLiterals
        {
            get;
            private set;
        }

        public LiteralCheckingVisitor()
        {
            InvalidDateLiterals = new List<DateLiteral>();
        }

        public override void Visit(DateLiteral literal)
        {
            DateTime date = DateTime.MinValue;

            if (!DateTime.TryParseExact(literal.Value, "d-M-yyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, out date))
            {
                InvalidDateLiterals.Add(literal);
            }
        }
    }
}
