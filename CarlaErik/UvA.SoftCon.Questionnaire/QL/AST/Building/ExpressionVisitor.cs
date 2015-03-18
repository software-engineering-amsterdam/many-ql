using System;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.Grammar;

namespace UvA.SoftCon.Questionnaire.QL.AST.Building
{
    /// <summary>
    /// Represents a visitor for the <c>expr</c> parser rule.
    /// </summary>
    internal class ExpressionVisitor : QLBaseVisitor<Expression>
    {
        public override Expression VisitPrecedenceOverride(QLParser.PrecedenceOverrideContext context)
        {
            return context.expr().Accept(this);
        }

        public override Expression VisitNegation(QLParser.NegationContext context)
        {
            Expression operand = context.expr().Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(0).GetText());

            return new Negation(operation, operand, context.GetTextPosition());
        }

        public override Expression VisitMultiplyDivide(QLParser.MultiplyDivideContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            switch (operation)
            {
                case Operation.Multiply:
                    return new Multiply(operation, left, right, context.GetTextPosition());
                case Operation.Divide:
                    return new Divide(operation, left, right, context.GetTextPosition());
                default:
                    throw new NotSupportedException("Unexpected operator symbol encountered.");
            }
        }

        public override Expression VisitAddSubstract(QLParser.AddSubstractContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            switch (operation)
            {
                case Operation.Add:
                    return new Add(operation, left, right, context.GetTextPosition());
                case Operation.Substract:
                    return new Substract(operation, left, right, context.GetTextPosition());
                default:
                    throw new NotSupportedException("Unexpected operator symbol encountered.");
            }
        }

        public override Expression VisitRelational(QLParser.RelationalContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            switch (operation)
            {
                case Operation.GreaterThan:
                    return new GreaterThan(operation, left, right, context.GetTextPosition());
                case Operation.GreaterThanOrEqualTo:
                    return new GreaterThanOrEqualTo(operation, left, right, context.GetTextPosition());
                case Operation.LessThan:
                    return new LessThan(operation, left, right, context.GetTextPosition());
                case Operation.LessThanOrEqualTo:
                    return new LessThanOrEqualTo(operation, left, right, context.GetTextPosition());
                default:
                    throw new NotSupportedException("Unexpected operator symbol encountered.");
            }
        }

        public override Expression VisitEquality(QLParser.EqualityContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            switch (operation)
            {
                case Operation.EqualTo:
                    return new EqualTo(operation, left, right, context.GetTextPosition());
                case Operation.NotEqualTo:
                    return new NotEqualTo(operation, left, right, context.GetTextPosition());
                default:
                    throw new NotSupportedException("Unexpected operator symbol encountered.");
            }
        }

        public override Expression VisitAnd(QLParser.AndContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new And(operation, left, right, context.GetTextPosition());
        }

        public override Expression VisitOr(QLParser.OrContext context)
        {
            Expression left = context.expr(0).Accept(this);
            Expression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new Or(operation, left, right, context.GetTextPosition());
        }

        public override Expression VisitIdentifier(QLParser.IdentifierContext context)
        {
            return new Identifier(context.ID().GetText(), context.GetTextPosition());
        }

        public override Expression VisitBooleanLiteral(QLParser.BooleanLiteralContext context)
        {
            return new BooleanLiteral(context.BOOL().GetText(), context.GetTextPosition());
        }

        public override Expression VisitIntegerLiteral(QLParser.IntegerLiteralContext context)
        {
            return new IntegerLiteral(context.INT().GetText(), context.GetTextPosition());
        }

        public override Expression VisitStringLiteral(QLParser.StringLiteralContext context)
        {
            string value = context.STRING().GetText();

            // Remove the leading and trailing '"' characters from the string literal.
            value = value.Trim('"');

            return new StringLiteral(value, context.GetTextPosition());
        }

        public override Expression VisitDateLiteral(QLParser.DateLiteralContext context)
        {
            string date = context.DATE().GetText().Replace("[", "").Replace("]", "");

            return new DateLiteral(date, context.GetTextPosition());
        }
    }
}
