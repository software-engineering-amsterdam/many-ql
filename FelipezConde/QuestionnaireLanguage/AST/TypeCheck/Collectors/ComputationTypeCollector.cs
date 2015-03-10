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
    public class ComputationTypeCollector : BaseVisitor<IValue>
    {
        private readonly Dictionary<string, IValue> idToType;
        private List<INotification> collectedNotifications = new List<INotification>();

        public IList<INotification> GetCollectedNotifications()
        { return collectedNotifications; }

        public void ClearCollectedNotifications()
        { collectedNotifications = new List<INotification>(); }

        public ComputationTypeCollector(Dictionary<string,IValue> idToType)
        {
            this.idToType = idToType;
        }
        public override IValue Visit(Nodes.Computation.Expression node)
        {
            return node.Accept(new ExpressionTypeCollector(idToType));
        }
        public override IValue Visit(Nodes.Computation.Id node)
        {
            return idToType[node.Value];
        }

        public override IValue Visit(Nodes.Computation.Value node)
        {
            return node.ElementValue;
        }
    }
}
