using AST;
using AST.Nodes;
using AST.Nodes.Expressions;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Checkers;
using TypeChecking.Collectors;
using Types = AST.Types;

namespace TypeChecking
{
    public static class MainTypeChecker
    {
        public static ASTResult GetTypeCheckDiagnosis(ASTResult astResult)
        {
            //Precondition: no previous errors
            if (astResult.HasError()) // if it already has errors, refuse to add more
                return astResult;

            Form rootNode = astResult.RootNode;
            INotificationManager manager = new NotificationManager();

            manager.Combine(new IdentifierChecker(manager).AnalyzeAndReport(rootNode));

            manager.Combine(new ExpressionContainerChecker(manager, GetIdentifierTypes(rootNode))
                            .AnalyzeAndReport(rootNode.GetBody())
                );

            manager.Combine(new CyclicDependencyChecker(manager).AnalyzeAndReport(rootNode.GetBody()));
            manager.Combine(new LabelChecker().AnalyzeAndReport(rootNode.GetBody()));

            astResult.CombineNotifications(manager);

            return astResult;
        }

        private static Dictionary<Id, Types.Type> GetIdentifierTypes(Form node)
        {
            return node.Accept(new IdentifierTypeCollector()).ToDictionary(id => id, id => id.RetrieveType());
        }


    }
}
