using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.String;
using UvA.SoftCon.Questionnaire.AST.Identifiers;
using UvA.SoftCon.Questionnaire.AST.Literals;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>string_expr</c> parser rule.
    /// </summary>
    internal class StringExpressionVisitor : QLBaseVisitor<IStringExpression>
    {
        public override IStringExpression VisitConcatination(QLParser.ConcatinationContext context)
        {
            IStringExpression left = context.string_expr(0).Accept(this);
            IStringExpression right = context.string_expr(1).Accept(this);

            return new ConcatinationExpression(left, right);
        }

        public override IStringExpression VisitStringId(QLParser.StringIdContext context)
        {
            return new StringIdentifier(context.ID().GetText());
        }

        public override IStringExpression VisitStringLiteral(QLParser.StringLiteralContext context)
        {
            return new StringLiteral(context.STRING().GetText());
        }
    }
}
