using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions.Boolean;
using UvA.SoftCon.Questionnaire.AST.Expressions.Numeric;
using UvA.SoftCon.Questionnaire.AST.Identifiers;
using UvA.SoftCon.Questionnaire.AST.Literals;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>bool_expr</c> parser rule.
    /// </summary>
    internal class BooleanExpressionVisitor : QLBaseVisitor<IBooleanExpression>
    {
        public override IBooleanExpression VisitPrecedence(QLParser.PrecedenceContext context)
        {
            return context.bool_expr().Accept(this);
        }

        public override IBooleanExpression VisitAndExpression(QLParser.AndExpressionContext context)
        {
            IBooleanExpression left = context.bool_expr(0).Accept(this);
            IBooleanExpression right = context.bool_expr(1).Accept(this);

            return new AndExpression(left, right);
        }

        public override IBooleanExpression VisitOrExpression(QLParser.OrExpressionContext context)
        {
            IBooleanExpression left = context.bool_expr(0).Accept(this);
            IBooleanExpression right = context.bool_expr(1).Accept(this);

            return new OrExpression(left, right);
        }

        public override IBooleanExpression VisitGreaterThan(QLParser.GreaterThanContext context)
        {
            INumericExpression left = context.num_expr(0).Accept(new NumericExpressionVisitor());
            INumericExpression right = context.num_expr(1).Accept(new NumericExpressionVisitor());

            return new GreaterThanExpression(left, right);
        }

        public override IBooleanExpression VisitLessThan(QLParser.LessThanContext context)
        {
            INumericExpression left = context.num_expr(0).Accept(new NumericExpressionVisitor());
            INumericExpression right = context.num_expr(1).Accept(new NumericExpressionVisitor());

            return new LessThanExpression(left, right);
        }

        public override IBooleanExpression VisitBooleanEquals(QLParser.BooleanEqualsContext context)
        {
            IBooleanExpression left = context.bool_expr(0).Accept(this);
            IBooleanExpression right = context.bool_expr(1).Accept(this);

            return new BooleanEqualsExpression(left, right);
        }

        public override IBooleanExpression VisitNumericEquals(QLParser.NumericEqualsContext context)
        {
            INumericExpression left = context.num_expr(0).Accept(new NumericExpressionVisitor());
            INumericExpression right = context.num_expr(1).Accept(new NumericExpressionVisitor());

            return new NumericEqualsExpression(left, right);
        }

        public override IBooleanExpression VisitBooleanId(QLParser.BooleanIdContext context)
        {
            return new BooleanIdentifier(context.ID().GetText());
        }

        public override IBooleanExpression VisitBooleanLiteral(QLParser.BooleanLiteralContext context)
        {
            bool value = Boolean.Parse(context.BOOL().GetText());

            return new BooleanLiteral(value);
        }
    }
}
