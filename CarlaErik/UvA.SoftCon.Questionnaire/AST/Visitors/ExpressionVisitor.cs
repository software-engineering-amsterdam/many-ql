using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Expressions;
using UvA.SoftCon.Questionnaire.AST.Identifiers;
using UvA.SoftCon.Questionnaire.AST.Literals;
using UvA.SoftCon.Questionnaire.Parsing;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    internal class ExpressionVisitor : QLBaseVisitor<IExpression>
    {
        public override IExpression VisitPrecedenceOverride(QLParser.PrecedenceOverrideContext context)
        {
            return context.expr().Accept(this);
        }

        public override IExpression VisitMultiplyDivide(QLParser.MultiplyDivideContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            string @operator = context.GetChild(1).GetText();

            switch(@operator) {
                case "*":
                    return new Multiply(left, right);
                case "/":
                    return new Divide(left, right);
                default:
                    throw new NotSupportedException();
            }
        }

        public override IExpression VisitAddSubstract(QLParser.AddSubstractContext context)
        {
            return null;
        }

        public override IExpression VisitRelational(QLParser.RelationalContext context)
        {
            return base.VisitRelational(context);
        }

        public override IExpression VisitEquality(QLParser.EqualityContext context)
        {
            return base.VisitEquality(context);
        }

        public override IExpression VisitAnd(QLParser.AndContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);

            return new And(left, right);
        }

        public override IExpression VisitOr(QLParser.OrContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);

            return new Or(left, right);
        }

        public override IExpression VisitIdentifier(QLParser.IdentifierContext context)
        {
            return new Identifier(context.ID().GetText());
        }

        public override IExpression VisitBooleanLiteral(QLParser.BooleanLiteralContext context)
        {
            bool value = Boolean.Parse(context.BOOL().GetText());

            return new BooleanLiteral(value);
        }

        public override IExpression VisitIntegerLiteral(QLParser.IntegerLiteralContext context)
        {
            int value = Int32.Parse(context.INT().GetText());

            return new IntegerLiteral(value);
        }

        public override IExpression VisitDoubleLiteral(QLParser.DoubleLiteralContext context)
        {
            double value = Double.Parse(context.DOUBLE().GetText());

            return new DoubleLiteral(value);
        }

        public override IExpression VisitStringLiteral(QLParser.StringLiteralContext context)
        {
            return new StringLiteral(context.STRING().GetText());
        }
    }
}
