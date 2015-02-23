using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Checks ....
    /// </summary>
    /// <remarks>
    /// The type checker checks the following conditions:
    ///   - The expresison in if-statements should be of type boolean.
    ///   - Operands of invalid type to operators.
    ///   - 
    /// </remarks>
    public class TypeCheckingVisitor : ASTVisitor
    {
        private IDictionary<string, DataType> _declaredVariables = new Dictionary<string, DataType>();

        public ICollection<InvalidAssignment> InvalidAssignments
        {
            get;
            private set;
        }

        public ICollection<IfStatement> InvalidIfStatements
        {
            get;
            private set;
        }

        public ICollection<InvalidBinaryExpression> InvalidBinaryExpressions
        {
            get;
            private set;
        }

        public TypeCheckingVisitor()
        {
            InvalidAssignments = new List<InvalidAssignment>();
            InvalidIfStatements = new List<IfStatement>();
            InvalidBinaryExpressions = new List<InvalidBinaryExpression>();
        }

        public TypeCheckingVisitor(TypeCheckingVisitor parentVisitor)
        {
            _declaredVariables = parentVisitor._declaredVariables;
        }

        public override void Visit(Declaration declaration)
        {
            _declaredVariables.Add(declaration.Id.Name, declaration.DataType);

            if (declaration.Initialization != null)
            {
                DataType? expressionType = GetResultType(declaration.Initialization);

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
        }

        public override void Visit(Assignment assignment)
        {
            DataType? targetType = GetResultType(assignment.Variable);
            DataType? expressionType = GetResultType(assignment.Expression);

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
            _declaredVariables.Add(question.Id.Name, question.DataType);
        }

        public override void Visit(IfStatement ifStatement)
        {
            // Validate that the condition of the if statement is of type boolean
            DataType? result = GetResultType(ifStatement.If);

            if (result.HasValue)
            {
                if (result.Value != DataType.Boolean)
                {
                    InvalidIfStatements.Add(ifStatement);
                }
            }
            // Traverse the rest of the tree with a new visitor.
            var thenVisitor = new TypeCheckingVisitor(this);

            foreach(var statement in ifStatement.Then) {
                statement.Accept(thenVisitor);
            }

            var elseVisitor = new TypeCheckingVisitor(this);
            foreach (var statement in ifStatement.Else)
            {
                statement.Accept(elseVisitor);
            }
        }

        public override void Visit(BinaryExpression expression)
        {
            // Validate that the data type of the operands conform 
            DataType? left = GetResultType(expression.Left);
            DataType? right = GetResultType(expression.Right);

            if (left.HasValue && right.HasValue)
            {
                if (!BinaryExpressionIsValid(expression.Operation, left.Value, right.Value))
                {
                    InvalidBinaryExpressions.Add(new InvalidBinaryExpression(expression, left.Value, right.Value));
                }
            }
            else
            {
                // Traverse the rest of the tree.
                base.Visit(expression);
            }
        }

        private DataType? GetResultType(IExpression expression)
        {
            switch (expression.Type)
            {
                case NodeType.BinaryExpression:
                    return GetResultType((BinaryExpression)expression);
                case NodeType.Identifier:
                    var identifier = (Identifier)expression;
                    if (_declaredVariables.Keys.Contains(identifier.Name))
                    {
                        return _declaredVariables[identifier.Name];
                    }
                    else
                    {
                        // The identifier refers to a question or variable that
                        // has not been properly declared.
                        return null;
                    }
                case NodeType.BooleanLiteral:
                    return DataType.Boolean;
                case NodeType.DoubleLiteral:
                    return DataType.Double;
                case NodeType.IntegerLiteral:
                    return DataType.Integer;
                case NodeType.StringLiteral:
                    return DataType.String;
                default:
                    throw new ArgumentException("Unexpected node type for expression encountered.");
            }
        }

        private DataType? GetResultType(BinaryExpression expression)
        {
            DataType? leftDataType = GetResultType(expression.Left);
            DataType? rightDataType = GetResultType(expression.Right);

            switch (expression.Operation)
            {
                case Operation.And:
                case Operation.Equals:
                case Operation.GreaterThan:
                case Operation.GreaterThanOrEqualTo:
                case Operation.LessThan:
                case Operation.LessThanOrEqualTo:
                case Operation.NotEquals:
                case Operation.Or:
                    return DataType.Boolean;

                // The result type of these expressions also depends on their operands.
                case Operation.Divide:
                    return DataType.Double;
                case Operation.Add:
                case Operation.Multiply:
                case Operation.Substract:
                    if (leftDataType.HasValue && rightDataType.HasValue)
                    {
                        if (leftDataType.Value == DataType.Integer && rightDataType.Value == DataType.Integer)
                        {
                            return DataType.Integer;
                        }
                        else if (leftDataType.Value == DataType.Double || rightDataType.Value == DataType.Double)
                        {
                            return DataType.Double;
                        }
                        else
                        {
                            return null;
                        }
                    }
                    else
                    {
                        return null;
                    }
                default:
                    return null;
            }
        }

        private bool BinaryExpressionIsValid(Operation operation, DataType left, DataType right)
        {
            switch (operation)
            {
                case Operation.And:
                case Operation.Or:
                    return left == DataType.Boolean && right == DataType.Boolean;
                case Operation.NotEquals:
                case Operation.Equals:
                    return left == right;
                case Operation.Add:
                case Operation.Divide:
                case Operation.Multiply:
                case Operation.Substract:
                case Operation.GreaterThan:
                case Operation.GreaterThanOrEqualTo:
                case Operation.LessThan:
                case Operation.LessThanOrEqualTo:
                    return (left == DataType.Integer || left == DataType.Double) && (right == DataType.Integer || right == DataType.Double);
                default:
                    throw new NotSupportedException();
            }
        }
    }
}
