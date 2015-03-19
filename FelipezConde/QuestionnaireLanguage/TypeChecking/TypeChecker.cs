using AST;
using AST.Nodes;
using Notifications;
using System.Collections.Generic;

namespace TypeChecking
{
    public static class TypeChecker
    {
        public static ASTResult GetTypeCheckDiagnosis(ASTResult astResult)
        {
            List<INotification> notifications = new List<INotification>(); 

            INotificationManager notificationManager = new NotificationManager();

            //notificationManager = new IdentifierChecker(astResult.RootNode, notificationManager).AnalyzeAndReport();
            //notifications.AddRange(new ExpressionChecker(astResult.RootNode).AnalyzeAndReport());

            //ASTResult result = new ASTResult()

            return null;
        }


    }
}
