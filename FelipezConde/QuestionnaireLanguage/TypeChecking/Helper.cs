using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Collectors;
using Types = AST.Types;

namespace TypeChecking
{
    public static class Helper
    {
        public static Dictionary<Id, Types.Type> GetIdentifierTypes(Form node)
        {
           return node.Accept(new IdentifierTypeCollector()).ToDictionary(id => id, id => id.RetrieveType());
        }
        public static IList<Question> GetDefinedIdentifiers(Form node)
        {
            return node.Accept(new QuestionCollector());
        }

        public static bool ContainsError(IList<INotification> notifications)
        {
            foreach (INotification notification in notifications)
            {
                if (notification.IsError()) return true;
            }

            return false;
        }
    }
}
