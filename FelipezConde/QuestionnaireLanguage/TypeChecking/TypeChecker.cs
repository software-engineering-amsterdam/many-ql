using AST;
using AST.Nodes;
using AST.Nodes.Expressions;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Collectors;
using Types = AST.Types;

namespace TypeChecking
{
    public static class TypeChecker
    {
        public static ASTResult GetTypeCheckDiagnosis(ASTResult astResult)
        {
            List<INotification> notifications = new List<INotification>();

            INotificationManager notificationManager = new NotificationManager();

            Form rootNode = astResult.RootNode;

            notificationManager = IdentifierChecker.AnalyzeAndReport(rootNode);

            ExpressionContainerChecker expressionContainerChecker = new ExpressionContainerChecker(GetIdentifierTypes(rootNode));
            notificationManager.Combine(expressionContainerChecker.AnalyzeAndReport(rootNode.GetBody()));
            //notificationManager.Combine(new CyclicDependencyChecker().AnalyzeAndReport(rootNode.GetBody()));
            notificationManager.Combine(new LabelChecker().AnalyzeAndReport(rootNode.GetBody()));

            astResult.NotificationManager.Combine(notificationManager);

            return astResult;
        }

        private static Dictionary<Id, Types.Type> GetIdentifierTypes(Form node)
        {
            return node.Accept(new IdentifierTypeCollector()).ToDictionary(id => id, id => id.RetrieveType());
        }


    }
}
