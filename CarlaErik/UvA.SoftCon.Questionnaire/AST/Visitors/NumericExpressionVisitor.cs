using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;
using UvA.SoftCon.Questionnaire.AST.Identifiers;
using UvA.SoftCon.Questionnaire.AST.Literals;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>num_expr</c> parser rule.
    /// </summary>
    internal class NumericExpressionVisitor : QLBaseVisitor<INumericExpression>
    {
        public override INumericExpression VisitMultDiv(QLParser.MultDivContext context)
        {
            string operation = context.GetChild(1).GetText();

            return null;
        }

        public override INumericExpression VisitNumericId(QLParser.NumericIdContext context)
        {
            return new NumericIdentifier(context.ID().GetText());
        }

        public override INumericExpression VisitIntegerLiteral(QLParser.IntegerLiteralContext context)
        {
            int value = Int32.Parse(context.INT().GetText());

            return new IntegerLiteral(value);
        }
    }
}
