using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks if expressions are valid to their operators or questions and if redeclared questions have the same type.
    /// </summary>
    public class TypeChecker : ASTChecker
    {
        private IDictionary<string, DataType> _symbolTable = new Dictionary<string, DataType>();

        public TypeChecker()
        {
        }

        public override object Visit(Question question)
        {
            if (question.IsComputed)
            {
                DataType expressionType = question.Expression.GetType(_symbolTable);

                if (expressionType != DataType.Undefined)
                {
                    if (question.DataType != expressionType)
                    {
                        Report.AddError(question.Position, "Cannot assign a value of type '{0}' to question '{1}' of type '{2}'.",
                            StringEnum.GetStringValue(expressionType), question.Id.Name, StringEnum.GetStringValue(question.DataType));
                    }
                }

                question.Expression.Accept(this);
            }

            // Check when the question is redeclared, it is of the smae type.
            if (_symbolTable.ContainsKey(question.Id.Name))
            {
                if (question.DataType != _symbolTable[question.Id.Name])
                {
                    Report.AddError(question.Position, "Cannot redeclare a question with a different type.");
                }
            }

            _symbolTable.Add(question.Id.Name, question.DataType);
            return null;
        }

        public override object Visit(IfStatement ifStatement)
        {
            // Validate that the condition of the if statement is of type boolean.
            DataType expressionType = ifStatement.If.GetType(_symbolTable);

            if (expressionType != DataType.Undefined)
            {
                if (expressionType != DataType.Boolean)
                {
                    Report.AddError(ifStatement.Position, "Condition of if-statement is not a boolean expression.");
                }
            }

            // Validate the inner parts of the expression.
            return base.Visit(ifStatement);
        }

        public override object Visit(Add add)
        {
            ValidateBinaryExpression(add);
            return base.Visit(add);
        }

        public override object Visit(And and)
        {
            ValidateBinaryExpression(and);
            return base.Visit(and);
        }

        public override object Visit(Divide divide)
        {
            ValidateBinaryExpression(divide);
            return base.Visit(divide);
        }

        public override object Visit(EqualTo equalTo)
        {
            ValidateBinaryExpression(equalTo);
            return base.Visit(equalTo);
        }

        public override object Visit(GreaterThan greaterThan)
        {
            ValidateBinaryExpression(greaterThan);
            return base.Visit(greaterThan);
        }

        public override object Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            ValidateBinaryExpression(greaterThanOrEqualTo);
            return base.Visit(greaterThanOrEqualTo);
        }

        public override object Visit(LessThan lessThan)
        {
            ValidateBinaryExpression(lessThan);
            return base.Visit(lessThan);
        }

        public override object Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            ValidateBinaryExpression(lessThanOrEqualTo);
            return base.Visit(lessThanOrEqualTo);
        }

        public override object Visit(Multiply multiply)
        {
            ValidateBinaryExpression(multiply);
            return base.Visit(multiply);
        }

        public override object Visit(Negation negation)
        {
            ValidateUnaryExpression(negation);
            return base.Visit(negation);
        }

        public override object Visit(NotEqualTo notEqualTo)
        {
            ValidateBinaryExpression(notEqualTo);
            return base.Visit(notEqualTo);
        }

        public override object Visit(Or or)
        {
            ValidateBinaryExpression(or);
            return base.Visit(or);
        }

        public override object Visit(Substract substract)
        {
            ValidateBinaryExpression(substract);
            return base.Visit(substract);
        }

        private void ValidateUnaryExpression(UnaryExpression expression)
        {
            DataType operandType = expression.Operand.GetType(_symbolTable);

            if (operandType != DataType.Undefined)
            {
                if (!expression.OperandTypeIsValid(operandType))
                {

                    Report.AddError(expression.Position, "Operator '{0}' can not be applied to operand of type '{1}'.",           
                        StringEnum.GetStringValue(expression.Operation), operandType);
                }
            }
        }

        private void ValidateBinaryExpression(BinaryExpression expression)
        {
            DataType leftType = expression.Left.GetType(_symbolTable);
            DataType rightType = expression.Right.GetType(_symbolTable);

            if (leftType != DataType.Undefined && rightType != DataType.Undefined)
            {
                if (!expression.OperandTypesAreValid(leftType, rightType))
                {
                    Report.AddError(expression.Position, "Operator '{0}' can not be applied to operands of type '{1}' and '{2}'.",
                        StringEnum.GetStringValue(expression.Operation), StringEnum.GetStringValue(leftType), StringEnum.GetStringValue(rightType));
                }
            }
        }
    }
}
