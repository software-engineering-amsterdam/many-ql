using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
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
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitAddSubstract(QLParser.AddSubstractContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitRelational(QLParser.RelationalContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitEquality(QLParser.EqualityContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitAnd(QLParser.AndContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

            return new BinaryExpression(operation, left, right);
        }

        public override IExpression VisitOr(QLParser.OrContext context)
        {
            IExpression left = context.expr(0).Accept(this);
            IExpression right = context.expr(1).Accept(this);
            Operation operation = OperatorStringToEnum(context.GetChild(1).GetText());

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
            return new Literal<string>(context.STRING().GetText());
        }

        private static Operation OperatorStringToEnum(string value)
        {
            switch (value)
            {
                case "*":
                    return Operation.Multiply;
                case "/":
                    return Operation.Divide;
                case "+":
                    return Operation.Add;
                case "-":
                    return Operation.Substract;
                case "<":
                    return Operation.LessThan;
                case ">":
                    return Operation.GreaterThan;
                case "<=":
                    return Operation.LessThanOrEqualTo;
                case ">=":
                    return Operation.GreaterThanOrEqualTo;
                case "==":
                    return Operation.Equals;
                case "!=":
                    return Operation.NotEquals;
                case "&&":
                    return Operation.And;
                case "||":
                    return Operation.Or;
                default:
                    throw new ArgumentException("Parameter value does not contain a valid operator. Value: " + value);
            }
        }
    }
}
