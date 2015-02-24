using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary;
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

        //public override void Visit(BinaryExpression expression)
        //{
        //    // Validate that the data type of the operands conform 
        //    DataType? left = expression.Left.GetType(_declaredVariables);
        //    DataType? right = GetResultType(expression.Right);

        //    if (left.HasValue && right.HasValue)
        //    {
        //        if (!BinaryExpressionIsValid(expression.Operation, left.Value, right.Value))
        //        {
        //            InvalidBinaryExpressions.Add(new InvalidBinaryExpression(expression, left.Value, right.Value));
        //        }
        //    }
        //    else
        //    {
        //        // Traverse the rest of the tree.
        //        base.Visit(expression);
        //    }
        //}


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
                    return (left == DataType.Integer || left == DataType.Double) && (right == DataType.Integer || right == DataType.Double);
                default:
                    throw new NotSupportedException();
            }
        }
    }
}
