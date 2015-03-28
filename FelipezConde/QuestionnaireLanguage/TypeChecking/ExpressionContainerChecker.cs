using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using AST.VisitorInterfaces;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Collectors;
using TypeChecking.Notifications.Errors;
using Types = AST.Types;

namespace TypeChecking
{
    public class ExpressionContainerChecker : IFormObjectVisitor<INotificationManager>
    {
        private readonly Dictionary<Id, Types.Type> identifierToType;

        public ExpressionContainerChecker(Dictionary<Id, Types.Type> identifierToType)
        {
            this.identifierToType = identifierToType;
        }

        public INotificationManager AnalyzeAndReport(IList<FormObject> formObjects)
        {
            NotificationManager notificationManager = new NotificationManager();

            foreach (FormObject formObject in formObjects)
            {
                notificationManager.Combine(formObject.Accept(this));
            }

            return notificationManager;
        }

        public INotificationManager Visit(Conditional conditional)
        {
            INotificationManager notificationManager = Conditional_Expression_Is_BoolType(conditional);
            notificationManager.Combine(Expression_Arguments_Are_Compatible(conditional.Condition));

            return notificationManager;
        }

        private INotificationManager Conditional_Expression_Is_BoolType(Conditional conditional)
        {
            INotificationManager notificationManager = new NotificationManager();
            Types.Type type = conditional.Condition.Accept(new ExpressionTypeCollector(identifierToType));

            if (!type.IsEqual(new Types.BoolType()))
            {
                notificationManager.AddNotification(new NonBooleanCondition(conditional.GetPosition()));
            }

            return notificationManager;
        }

        public INotificationManager Visit(Question question)
        {
            INotificationManager notificationManager = new NotificationManager();

            if (question.Computation != null)
            {
                notificationManager.Combine(Expression_Arguments_Are_Compatible(question.Computation));

                Types.Type type = question.Computation.Accept(new ExpressionTypeCollector(identifierToType));
                
                if (!type.IsEqual(question.RetrieveType()))
                {
                    notificationManager.AddNotification(new ComputedQuestionTypeConflict(question,type));
                }
            }

            return notificationManager;
        }

        private INotificationManager Expression_Arguments_Are_Compatible(Expression expression)
        {
            return expression.Accept(new ExpressionErrorCollector(identifierToType));
        }
    }
}
