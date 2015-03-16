using AST.Nodes;
using Notifications;
using System.Collections.Generic;

namespace TypeChecking
{
    public static class TypeCheckManager
    {
        public static List<INotification> GetTypeCheckDiagnosis(Form node)
        {
            List<INotification> notifications = new List<INotification>(); 

            notifications.AddRange(new IdentifierChecker(node).AnalyzeAndReport());
            notifications.AddRange(new ExpressionChecker(node).AnalyzeAndReport());
            //TODO: Add Cyclic dependency check

            return notifications;
        }

        public static bool IsTypeCorrect(Form node)
        {
            return Helper.ContainsError(GetTypeCheckDiagnosis(node));
        }

    }
}
