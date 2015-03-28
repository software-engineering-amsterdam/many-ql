using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using Notifications;
using System.Collections.Generic;
using TypeChecking.Notifications.Errors;
using Types = AST.Types;
using AST.VisitorInterfaces;

namespace TypeChecking.Collectors
{
    public class ExpressionErrorCollector : IExpressionVisitor<INotificationManager>
    {
        private readonly Dictionary<Id, Types.Type> idToType;

        public ExpressionErrorCollector(Dictionary<Id, Types.Type> idToType)
        {
            this.idToType = idToType;
        }

        #region Id
        public INotificationManager Visit(Id node)
        {
            return new NotificationManager();
        }
        #endregion

        #region Binary
        public  INotificationManager Visit(And node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public  INotificationManager Visit(Or node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public  INotificationManager Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public  INotificationManager Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public  INotificationManager Visit(GreaterThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(GreaterThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(LessThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(LessThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(Add node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(Subtract node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(Multiply node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public  INotificationManager Visit(Divide node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }
        #endregion

        #region Unary
        public  INotificationManager Visit(Negate node)
        {
            return VisitUnaryExpectedType(node, new Types.BoolType());
        }
        public  INotificationManager Visit(Priority node)
        {
            return VisitUnary(node);
        }
        #endregion

        #region Literals
        public INotificationManager Visit(AST.Nodes.Literals.Bool node)
        {
            return new NotificationManager();
        }
        public INotificationManager Visit(AST.Nodes.Literals.Int node)
        {
            return new NotificationManager();
        }
        public INotificationManager Visit(AST.Nodes.Literals.String node)
        {
            return new NotificationManager();
        }
        #endregion

        private INotificationManager VisitBinaryExpectedType(Binary node, Types.Type expectedType)
        {
            INotificationManager notificationManager = new NotificationManager();

            Types.Type left = node.Left().Accept(new ExpressionTypeCollector(idToType));
            Types.Type right = node.Right().Accept(new ExpressionTypeCollector(idToType));

            if (!left.IsEqual(expectedType) && right.IsEqual(expectedType))
            {
                notificationManager.AddNotification(new IncompatibleBinaryOperator(node, left, right));
            }

            return notificationManager;
        }
        private INotificationManager VisitBinary(Binary node)
        {
            INotificationManager notificationManager = CollectChildrenErrors(node.Left(), node.Right());

            Types.Type left = node.Left().Accept(new ExpressionTypeCollector(idToType));
            Types.Type right = node.Right().Accept(new ExpressionTypeCollector(idToType));

            if (!left.IsEqual(right))
            {
                notificationManager.AddNotification(new IncompatibleBinaryOperator(node, left, right));
            }

            return notificationManager;
        }
        private INotificationManager CollectChildrenErrors(Expression left, Expression right)
        {
            INotificationManager notificationManager = new NotificationManager();

            notificationManager.Combine(left.Accept(this));
            notificationManager.Combine(right.Accept(this));

            return notificationManager;
        }
        private INotificationManager VisitUnary(Unary node)
        {
            return node.GetChildExpression().Accept(this);
        }
        private INotificationManager VisitUnaryExpectedType(Unary node, Types.Type expectedType)
        {
            INotificationManager notificationManager = node.GetChildExpression().Accept(this);

            Types.Type childType = node.GetChildExpression().Accept(new ExpressionTypeCollector(idToType));

            if (childType.IsEqual(expectedType))
            {
                notificationManager.AddNotification(new IncompatibleUnaryOperator(node, childType));
            }

            return notificationManager;
        }
    }
}
