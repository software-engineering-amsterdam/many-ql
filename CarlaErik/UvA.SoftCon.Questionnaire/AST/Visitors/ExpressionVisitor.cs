using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.Parsing;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.AST.Visitors
{
    /// <summary>
    /// Represents a visitor for the <c>expr</c> parser rule.
    /// </summary>
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
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }


        public override IExpression VisitAddSubstract(QLParser.AddSubstractContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitRelational(QLParser.RelationalContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitEquality(QLParser.EqualityContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitAnd(QLParser.AndContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitOr(QLParser.OrContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitIdentifier(QLParser.IdentifierContext context)
        {
            return new Identifier(context.ID().GetText());
        }

        public override IExpression VisitBooleanLiteral(QLParser.BooleanLiteralContext context)
        {
            bool value = Boolean.Parse(context.BOOL().GetText());

            return new Literal<bool>(value);
        }

        public override IExpression VisitIntegerLiteral(QLParser.IntegerLiteralContext context)
        {
            int value = Int32.Parse(context.INT().GetText());

            return new Literal<int>(value);
        }

        public override IExpression VisitDoubleLiteral(QLParser.DoubleLiteralContext context)
        {
            double value = Double.Parse(context.DOUBLE().GetText());

            return new Literal<double>(value);
        }

        public override IExpression VisitStringLiteral(QLParser.StringLiteralContext context)
        {
            string value = context.STRING().GetText();
            
            // Remove the leading and trailing '"' characters from the string literal.
            value = value.Trim('"');

            return new Literal<string>(value);
        }
    }
}
