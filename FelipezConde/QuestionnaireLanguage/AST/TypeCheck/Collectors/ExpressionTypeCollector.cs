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
        private readonly Dictionary<string, Types.Type> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        public ExpressionTypeCollector(Dictionary<string, Types.Type> idToType)
        {
            this.idToType = idToType;
        }

        public override Types.Type Visit(IUnary node)
        {
            Types.Type childType = node.GetChildExpression().Accept(this);
            Types.Type expressionType = node.GetCompatibleType((dynamic)childType);

            if (IsUndefined(expressionType) && !IsUndefined(childType))
            {
                collectedNotifications.Add(new IncompatibleUnaryOperator(node.GetPosition(), node.MakeString(), childType.GetString()));
            }

            return expressionType;
        }

        private bool IsUndefined(Types.Type value)
        {
            return value.Equals(new Undefined());
        }

        public override Types.Type Visit(IBinary node)
        {
            Types.Type left = node.Left().Accept(this);
            Types.Type right = node.Right().Accept(this);
            Types.Type expressionType = node.GetCompatibleType((dynamic)left, (dynamic)right);

            if (IsUndefined(expressionType) && ( !IsUndefined(left) || !IsUndefined(right))) //second check is needed to not duplicate errors (Undefined is not compatible with anything)
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.MakeString(), left.GetString(), right.GetString()));
            }

            return expressionType;
        }

        //Containers
        public override Types.Type Visit(Container node)
        {
            return node.Value.RetrieveType();
        }

        public override Types.Type Visit(Id node)
        {
            return idToType[node.Identifier];
        }

    }
}
