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

namespace AST.TypeCheck.Collectors
{
    public class ExpressionTypeCollector : BaseVisitor<IValue>
    {
        private readonly Dictionary<string, IValue> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();        

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        public ExpressionTypeCollector(Dictionary<string,IValue> idToType)
        {
            this.idToType = idToType;
        }

        public override IValue Visit(IUnary node)
        {
            IValue childType = node.GetChildExpression().Accept(this);
            IValue expressionType = node.GetCompatibleType((dynamic)childType);

            if (IsUndefined(expressionType) && !IsUndefined(childType))
            {
                collectedNotifications.Add(new IncompatibleUnaryOperator(node.GetPosition(), node.MakeString(), childType.MakeString()));
            }

            return expressionType;
        }

        private bool IsUndefined(IValue value)
        {
            return value.IsOfType(new Undefined());
        }

        public override IValue Visit(IBinary node)
        {
            IValue left  = node.Left().Accept(this);
            IValue right = node.Right().Accept(this);
            IValue expressionType = node.GetCompatibleType((dynamic)left, (dynamic)right);

            if (IsUndefined(expressionType) && ( !IsUndefined(left) || !IsUndefined(right))) //second check is needed to not duplicate errors (Undefined is not compatible with anything)
            {
                collectedNotifications.Add(new IncompatibleBinaryOperator(node.GetPosition(), node.MakeString(), left.MakeString(), right.MakeString()));
            }

            return expressionType;
        }

        //Containers
        public override IValue Visit(Container node)
        {
            //this can be bad!
            throw new NotImplementedException();
            //return ((Value)node.Value);
        }

        public override IValue Visit(Id node)
        {
            return idToType[node.Identifier];
        }

    }
}
