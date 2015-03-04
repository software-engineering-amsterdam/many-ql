using System;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.Grammar;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.QL.AST.Visitors
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

        public override IExpression VisitIncrement(QLParser.IncrementContext context)
        {
            IExpression operand = context.expr().Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new Increment(operation, operand, context.GetTextPosition());
        }

        public override IExpression VisitNegation(QLParser.NegationContext context)
        {
            IExpression operand = context.expr().Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(0).GetText());

            return new Negation(operation, operand, context.GetTextPosition());
        }

        public override IExpression VisitMultiplyDivide(QLParser.MultiplyDivideContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
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


        public override IExpression VisitAddSubstract(QLParser.AddSubstractContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
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

        public override IExpression VisitRelational(QLParser.RelationalContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
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

        public override IExpression VisitEquality(QLParser.EqualityContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
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

        public override IExpression VisitAnd(QLParser.AndContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new And(operation, left, right, context.GetTextPosition());
        }

        public override IExpression VisitOr(QLParser.OrContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = StringEnum.GetEnumerationValue<Operation>(context.GetChild(1).GetText());

            return new Or(operation, left, right, context.GetTextPosition());
        }

        public override IExpression VisitIdentifier(QLParser.IdentifierContext context)
        {
            return new Identifier(context.ID().GetText(), context.GetTextPosition());
        }

        public override IExpression VisitBooleanLiteral(QLParser.BooleanLiteralContext context)
        {
            bool value = Boolean.Parse(context.BOOL().GetText());

            return new BooleanLiteral(value, context.GetTextPosition());
        }

        public override IExpression VisitIntegerLiteral(QLParser.IntegerLiteralContext context)
        {
            int value = Int32.Parse(context.INT().GetText());

            return new IntegerLiteral(value, context.GetTextPosition());
        }

        public override IExpression VisitStringLiteral(QLParser.StringLiteralContext context)
        {
            string value = context.STRING().GetText();
            
            // Remove the leading and trailing '"' characters from the string literal.
            value = value.Trim('"');

            return new StringLiteral(value, context.GetTextPosition());
        }

        public override IExpression VisitDateLiteral(QLParser.DateLiteralContext context)
        {
            string date = context.DATE().GetText().Replace("[", "").Replace("]", "");

            return new DateLiteral(date, context.GetTextPosition());
        }
    }
}
