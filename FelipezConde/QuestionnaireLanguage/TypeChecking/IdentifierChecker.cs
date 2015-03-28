using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Collectors;
using TypeChecking.Notifications.Errors;

namespace TypeChecking
{
    public static class IdentifierChecker
    {
        public static INotificationManager AnalyzeAndReport(Form node)
        {
            INotificationManager notificationManager = Has_Duplicate_Identifiers(node);
            
            notificationManager.Combine(Has_Undefined_Identifiers(node));

            return notificationManager;
        }

        private static INotificationManager Has_Duplicate_Identifiers(Form node)
        {
            List<Id> definedIdList = GetDefinedIdList(node);
            INotificationManager notificationManager = new NotificationManager();

            foreach (Id id  in definedIdList.GroupBy(s => s.Name).SelectMany(grp => grp.Skip(1)))
            {
                notificationManager.AddNotification(new DuplicateIdentifier(id.Name, id.GetPosition()));
            }

            return notificationManager;
        }

        private static INotificationManager Has_Undefined_Identifiers(Form node)
        {
            List<Id> definedIdList = GetDefinedIdList(node);
            List<Id> usedIdList = new List<Id>();
            INotificationManager notificationManager = new NotificationManager();

            foreach (FormObject formObject in node.GetBody())
            {
                usedIdList.AddRange(formObject.Accept(new UsedIdentifierCollector()));
            }

            notificationManager.AddNotifications(
                usedIdList.FindAll(id => !definedIdList.Contains(id))
                          .Select(id => new UndefinedIdentifier(id.GetPosition(),id.Name)
                          ));

            return notificationManager;
        }

        private static List<Id> GetDefinedIdList(Form node)
        {
            List<Id> definedIdList = new List<Id>();

            foreach (FormObject formObject in node.GetBody())
            {
                definedIdList.AddRange(formObject.Accept(new DefinedIdentifierCollector()));
            }

            return definedIdList;
        }
    }
}
