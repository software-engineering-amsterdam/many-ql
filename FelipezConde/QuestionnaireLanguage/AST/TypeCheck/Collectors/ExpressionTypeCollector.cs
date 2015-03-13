using System.Collections.Generic;
using AST.Visitors;
using AST.Nodes.Interfaces;
using AST.Notification;
using AST.Nodes.Expression;
using AST.Notification.Errors;

namespace AST.TypeCheck.Collectors
{
    public class ExpressionTypeCollector : BaseVisitor<Types.Type>
    {
        private readonly Dictionary<Id, Types.Type> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();

        public ExpressionTypeCollector(Dictionary<Id, Types.Type> idToType)
        {
            this.idToType = idToType;
        }

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        #region Id, container
        public override Types.Type Visit(Container node)
        {
            return node.Value.RetrieveType();
        }

        public override Types.Type Visit(Id node)
        {
            return idToType[node];
        }

        #endregion
        #region Binary

        public override Types.Type Visit(Nodes.Expression.Binary.And node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Or node)
        {
            return VisitBinaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Equal node)
        {
            return VisitBinary(node);
        }

        public override Types.Type Visit(Nodes.Expression.Binary.NotEqual node)
        {
            return VisitBinary(node);
        }

        public override Types.Type Visit(Nodes.Expression.Binary.GreaterThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.GreaterThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.LessThan node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.LessThanOrEqual node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Add node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Subtract node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Multiply node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Divide node)
        {
            return VisitBinaryExpectedType(node, new Types.IntType());
        }
        #endregion
        #region Unary

        public override Types.Type Visit(Nodes.Expression.Unary.Negate node)
        {
            return VisitUnaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Unary.Priority node)
        {
            return VisitUnary(node);
        }
        #endregion

        private Types.Type VisitBinaryExpectedType(IBinary node, Types.Type expectedType)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(expectedType) && right.IsEqual(expectedType))
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.MakeString(), left.GetString(), right.GetString()));
            }

            return expectedType;
        }
        private Types.Type VisitBinary(IBinary node)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(right))
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.MakeString(), left.GetString(), right.GetString()));
            }

            return left;
        }
        private Types.Type VisitUnary(IUnary node)
        {
            return node.GetChildExpression().Accept(this);
        }
        private Types.Type VisitUnaryExpectedType(IUnary node, Types.Type expectedType)
        {
            Types.Type childType = node.GetChildExpression().Accept(this);

            if (childType.IsEqual(expectedType))
            {
                collectedNotifications.Add(new IncompatibleUnaryOperator(node.GetPosition(), node.MakeString(), childType.GetString()));
            }

            return expectedType;
        }
    }
}
