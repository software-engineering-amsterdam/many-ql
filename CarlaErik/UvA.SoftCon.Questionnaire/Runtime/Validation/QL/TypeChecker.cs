using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks if expressions are valid to their operators and variables.
    /// </summary>
    public class TypeChecker : QLVisitor<object>
    {
        private IDictionary<string, DataType> _symbolTable = new Dictionary<string, DataType>();

        /// <summary>
        /// A collection of definitions which expression type differs from the target type.
        /// </summary>
        public ICollection<InvalidDefinition> InvalidDefinitions
        {
            get;
            private set;
        }

        /// <summary>
        /// A collection of if statements which if-condition is not a boolean expression.
        /// </summary>
        public ICollection<IfStatement> InvalidIfStatements
        {
            get;
            private set;
        }

        /// <summary>
        /// A collection of unary expressions which operators are not compatible with their operand.
        /// </summary>
        public ICollection<InvalidUnaryExpression> InvalidUnaryExpressions
        {
            get;
            private set;
        }

        /// <summary>
        /// A collection of binary expressions which operators are not compatible with their operands.
        /// </summary>
        public ICollection<InvalidBinaryExpression> InvalidBinaryExpressions
        {
            get;
            private set;
        }

        public TypeChecker()
        {
            InvalidDefinitions = new List<InvalidDefinition>();
            InvalidIfStatements = new List<IfStatement>();
            InvalidUnaryExpressions = new List<InvalidUnaryExpression>();
            InvalidBinaryExpressions = new List<InvalidBinaryExpression>();
        }

        public override object Visit(Definition definition)
        {
            DataType expressionType = definition.Expression.GetType(_symbolTable);

            if (expressionType != DataType.Undefined)
            {
                if (definition.DataType != expressionType)
                {
                    InvalidDefinitions.Add(new InvalidDefinition(definition.Id, definition.Expression, definition.DataType, expressionType));
                }
            }

            // Validate the inner parts of the expression.
            definition.Expression.Accept(this);

            _symbolTable.Add(definition.Id.Name, definition.DataType);
            return null;
        }

        public override object Visit(Question question)
        {
            DataType questionType = question.DataType;

            if (question.IsComputed)
            {
                DataType expressionType = question.Expression.GetType(_symbolTable);

                if (expressionType != DataType.Undefined)
                {
                    if (questionType != expressionType)
                    {
                        InvalidDefinitions.Add(new InvalidDefinition(question.Id, question.Expression, questionType, expressionType));
                    }
                }
            }

            _symbolTable.Add(question.Id.Name, question.DataType);
            return null;
        }

        public override object Visit(IfStatement ifStatement)
        {
            // Validate that the condition of the if statement is of type boolean
            DataType expressionType = ifStatement.If.GetType(_symbolTable);

            if (expressionType != DataType.Undefined)
            {
                if (expressionType != DataType.Boolean)
                {
                    InvalidIfStatements.Add(ifStatement);
                }
            }

            foreach(var statement in ifStatement.Then) 
            {
                statement.Accept(this);
            }

            foreach (var statement in ifStatement.Else)
            {
                statement.Accept(this);
            }
            return null;
        }

        public override object Visit(Add add)
        {
            base.Visit(add);
            ValidateBinaryExpression(add);
            return null;
        }

        public override object Visit(And and)
        {
            base.Visit(and);
            ValidateBinaryExpression(and);
            return null;
        }

        public override object Visit(Divide divide)
        {
            base.Visit(divide);
            ValidateBinaryExpression(divide);
            return null;
        }

        public override object Visit(EqualTo equalTo)
        {
            base.Visit(equalTo);
            ValidateBinaryExpression(equalTo);
            return null;
        }

        public override object Visit(GreaterThan greaterThan)
        {
            base.Visit(greaterThan);
            ValidateBinaryExpression(greaterThan);
            return null;
        }

        public override object Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            base.Visit(greaterThanOrEqualTo);
            ValidateBinaryExpression(greaterThanOrEqualTo);
            return null;
        }

        public override object Visit(Increment increment)
        {
            base.Visit(increment);
            ValidateUnaryExpression(increment);
            return null;
        }

        public override object Visit(LessThan lessThan)
        {
            base.Visit(lessThan);
            ValidateBinaryExpression(lessThan);
            return null;
        }

        public override object Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            base.Visit(lessThanOrEqualTo);
            ValidateBinaryExpression(lessThanOrEqualTo);
            return null;
        }

        public override object Visit(Multiply multiply)
        {
            base.Visit(multiply);
            ValidateBinaryExpression(multiply);
            return null;
        }

        public override object Visit(Negation negation)
        {
            base.Visit(negation);
            ValidateUnaryExpression(negation);
            return null;
        }

        public override object Visit(NotEqualTo notEqualTo)
        {
            base.Visit(notEqualTo);
            ValidateBinaryExpression(notEqualTo);
            return null;
        }

        public override object Visit(Or or)
        {
            base.Visit(or);
            ValidateBinaryExpression(or);
            return null;
        }

        public override object Visit(Substract substract)
        {
            base.Visit(substract);
            ValidateBinaryExpression(substract);
            return null;
        }

        private void ValidateUnaryExpression(UnaryExpression expression)
        {
            DataType operandType = expression.Operand.GetType(_symbolTable);

            if (operandType != DataType.Undefined)
            {
                if (!expression.OperandTypeIsValid(operandType))
                {
                    InvalidUnaryExpressions.Add(new InvalidUnaryExpression(expression, operandType));
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
                    InvalidBinaryExpressions.Add(new InvalidBinaryExpression(expression, leftType, rightType));
                }
            }
        }
    }
}
