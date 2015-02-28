using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Checks if expressions are valid to their operators and variables.
    /// </summary>
    public class TypeCheckingVisitor : ASTVisitor
    {
        private IDictionary<string, DataType> _declaredVariables = new Dictionary<string, DataType>();

        /// <summary>
        /// A collection of assignments which expression type differs from the target type.
        /// </summary>
        public ICollection<InvalidAssignment> InvalidAssignments
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
            InvalidAssignments = new List<InvalidAssignment>();
            InvalidIfStatements = new List<IfStatement>();
            InvalidUnaryExpressions = new List<InvalidUnaryExpression>();
            InvalidBinaryExpressions = new List<InvalidBinaryExpression>();
        }

        public override void Visit(Declaration declaration)
        {
            if (declaration.Initialization != null)
            {
                DataType? expressionType = declaration.Initialization.GetType(_declaredVariables);

                if (expressionType.HasValue)
                {
                    if (declaration.DataType != expressionType.Value)
                    {
                        InvalidAssignments.Add(new InvalidAssignment(declaration.Id, declaration.Initialization, declaration.DataType, expressionType.Value));
                    }
                }

                // Validate the inner parts of the expression.
                declaration.Initialization.Accept(this);
            }

            _declaredVariables.Add(declaration.Id.Name, declaration.DataType);
        }

        public override void Visit(Assignment assignment)
        {
            DataType? targetType = assignment.Variable.GetType(_declaredVariables);
            DataType? expressionType = assignment.Expression.GetType(_declaredVariables);

            if (targetType.HasValue && expressionType.HasValue)
            {
                if (targetType.Value != expressionType.Value)
                {
                    InvalidAssignments.Add(new InvalidAssignment(assignment.Variable, assignment.Expression, targetType.Value, expressionType.Value));
                }
            }

            // Validate the inner parts of the expression.
            assignment.Expression.Accept(this);
        }

        public override void Visit(Question question)
        {
            DataType questionType = question.DataType;

            if (question.IsComputed)
            {
                DataType? expressionType = question.Expression.GetType(_declaredVariables);

                if (expressionType.HasValue)
                {
                    if (questionType != expressionType.Value)
                    {
                        InvalidAssignments.Add(new InvalidAssignment(question.Id, question.Expression, questionType, expressionType.Value));
                    }
                }
            }

            _declaredVariables.Add(question.Id.Name, question.DataType);
        }

        public override void Visit(IfStatement ifStatement)
        {
            // Validate that the condition of the if statement is of type boolean
            DataType? result = ifStatement.If.GetType(_declaredVariables);

            if (result.HasValue)
            {
                if (result.Value != DataType.Boolean)
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
            DataType? operand = expression.Operand.GetType(_declaredVariables);

            if (operand.HasValue)
            {
                if (!UnaryExpressionIsValid(expression.Operation, operand.Value))
                {
                    InvalidUnaryExpressions.Add(new InvalidUnaryExpression(expression, operand.Value));
                }
            }
        }

        private void ValidateBinaryExpression(BinaryExpression expression)
        {
            DataType? left = expression.Left.GetType(_declaredVariables);
            DataType? right = expression.Right.GetType(_declaredVariables);

            if (left.HasValue && right.HasValue)
            {
                if (!BinaryExpressionIsValid(expression.Operation, left.Value, right.Value))
                {
                    InvalidBinaryExpressions.Add(new InvalidBinaryExpression(expression, left.Value, right.Value));
                }
            }
        }

        private bool UnaryExpressionIsValid(Operation operation, DataType operand)
        {
            switch (operation)
            {
                case Operation.Increment:
                    return operand == DataType.Integer;
                case Operation.Negation:
                    return operand == DataType.Boolean;
                default:
                    throw new NotSupportedException();
            }
        }

        private bool BinaryExpressionIsValid(Operation operation, DataType left, DataType right)
        {
            switch (operation)
            {
                case Operation.And:
                case Operation.Or:
                    return left == DataType.Boolean && right == DataType.Boolean;
                case Operation.NotEqualTo:
                case Operation.EqualTo:
                    return left == right;
                case Operation.Add:
                case Operation.Divide:
                case Operation.Multiply:
                case Operation.Substract:
                case Operation.GreaterThan:
                case Operation.GreaterThanOrEqualTo:
                case Operation.LessThan:
                case Operation.LessThanOrEqualTo:
                    return (left == DataType.Integer) && (right == DataType.Integer);
                default:
                    throw new NotSupportedException();
            }
        }
    }
}
