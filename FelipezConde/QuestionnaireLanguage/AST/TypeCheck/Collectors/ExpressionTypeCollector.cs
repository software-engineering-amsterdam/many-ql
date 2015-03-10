using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Visitors;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Notification;
using AST.Nodes;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Expression;
using AST.Nodes.Expression.Unary;
using AST.Nodes.Values;
using AST.Notification.Errors;
using Types = AST.Types;

namespace AST.TypeCheck.Collectors
{
    public class ExpressionTypeCollector : BaseVisitor<Types.Type>
    {
        private readonly Dictionary<Id, Types.Type> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        public ExpressionTypeCollector(Dictionary<Id, Types.Type> idToType)
        {
            this.idToType = idToType;
        }

        public override Types.Type Visit(Container node)
        {
            return node.Value.RetrieveType();
        }

        public override Types.Type Visit(Id node)
        {
            return idToType[node];
        }
        public override Types.Type Visit(Nodes.Expression.Binary.And node)
        {
            return VisitBinary(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Or node)
        {
            return VisitBinary(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Equal node)
        {
            return VisitBinaryEqualTypes(node);
        }

        public override Types.Type Visit(Nodes.Expression.Binary.NotEqual node)
        {
            return VisitBinaryEqualTypes(node);
        }

        public override Types.Type Visit(Nodes.Expression.Binary.GreaterThan node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.GreaterThanOrEqual node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.LessThan node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.LessThanOrEqual node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Add node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Subtract node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Multiply node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Binary.Divide node)
        {
            return VisitBinary(node, new Types.IntType());
        }

        public override Types.Type Visit(Nodes.Expression.Unary.Negate node)
        {
            return VisitUnaryExpectedType(node, new Types.BoolType());
        }

        public override Types.Type Visit(Nodes.Expression.Unary.Priority node)
        {
            return VisitUnary(node);
        }

        private Types.Type VisitBinary(IBinary node, Types.Type expectedType)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);

            if (!left.IsEqual(expectedType) && right.IsEqual(expectedType))
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.MakeString(), left.GetString(), right.GetString()));
            }

            return expectedType;
        }

        private Types.Type VisitBinaryEqualTypes(IBinary node)
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
        private bool IsUndefined(Types.Type value)
        {
            return value.Equals(new Undefined());
        }

    }
}
