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
    public class TypeCheckingVisitor : QLVisitor
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

        public TypeCheckingVisitor()
        {
            InvalidDefinitions = new List<InvalidDefinition>();
            InvalidIfStatements = new List<IfStatement>();
            InvalidUnaryExpressions = new List<InvalidUnaryExpression>();
            InvalidBinaryExpressions = new List<InvalidBinaryExpression>();
        }

        public override void Visit(Definition definition)
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
        }

        public override void Visit(Question question)
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
        }

        public override void Visit(IfStatement ifStatement)
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
        }

        public override void Visit(Add add)
        {
            base.Visit(add);
            ValidateBinaryExpression(add);
        }

        public override void Visit(And and)
        {
            base.Visit(and);
            ValidateBinaryExpression(and);
        }

        public override void Visit(Divide divide)
        {
            base.Visit(divide);
            ValidateBinaryExpression(divide);
        }

        public override void Visit(EqualTo equalTo)
        {
            base.Visit(equalTo);
            ValidateBinaryExpression(equalTo);
        }

        public override void Visit(GreaterThan greaterThan)
        {
            base.Visit(greaterThan);
            ValidateBinaryExpression(greaterThan);
        }

        public override void Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            base.Visit(greaterThanOrEqualTo);
            ValidateBinaryExpression(greaterThanOrEqualTo);
        }

        public override void Visit(Increment increment)
        {
            base.Visit(increment);
            ValidateUnaryExpression(increment);
        }

        public override void Visit(LessThan lessThan)
        {
            base.Visit(lessThan);
            ValidateBinaryExpression(lessThan);
        }

        public override void Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            base.Visit(lessThanOrEqualTo);
            ValidateBinaryExpression(lessThanOrEqualTo);
        }

        public override void Visit(Multiply multiply)
        {
            base.Visit(multiply);
            ValidateBinaryExpression(multiply);
        }

        public override void Visit(Negation negation)
        {
            base.Visit(negation);
            ValidateUnaryExpression(negation);
        }

        public override void Visit(NotEqualTo notEqualTo)
        {
            base.Visit(notEqualTo);
            ValidateBinaryExpression(notEqualTo);
        }

        public override void Visit(Or or)
        {
            base.Visit(or);
            ValidateBinaryExpression(or);
        }

        public override void Visit(Substract substract)
        {
            base.Visit(substract);
            ValidateBinaryExpression(substract);
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
