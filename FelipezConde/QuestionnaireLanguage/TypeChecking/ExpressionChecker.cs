using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecking.Collectors;
using TypeChecking.Notifications.Errors;
using Types = AST.Types;

namespace TypeChecking
{
    public class ExpressionChecker
    {
        private readonly Form node;
        private readonly Dictionary<Id, Types.Type> identifierToType;
        private readonly IList<Expression> topLevelExpressions;

        public ExpressionChecker(Form node)
        {
            this.node = node;
            this.identifierToType = Helper.GetIdentifierTypes(node);
            this.topLevelExpressions = GetTopLevelExpressions();
        }

        public IList<INotification> AnalyzeAndReport()
        {
            List<INotification> Diagnosis = new List<INotification>();
         
            Diagnosis.AddRange(Expressions_Have_A_Consistent_Type());
            Diagnosis.AddRange(Computed_Question_Matches_Declaration());
            Diagnosis.AddRange(Conditional_Expressions_Evaluate_To_Bool());
            
            return Diagnosis;
        }

        private IEnumerable<INotification> Expressions_Have_A_Consistent_Type()
        {
            List<INotification> notifications = new List<INotification>();

            foreach (Expression expr in topLevelExpressions)
            {
                ExpressionTypeCollector collector = new ExpressionTypeCollector(identifierToType);

                expr.Accept(collector);

                notifications.AddRange(collector.GetCollectedNotifications());
            }

            return notifications;
        }

        private IEnumerable<INotification> Computed_Question_Matches_Declaration()
        {
            IList<Question> definedIdentifiers = Helper.GetDefinedIdentifiers(node);

            return definedIdentifiers.Where(q => q.Computation != null)
                                     .Where(q => !GetQuestionComputationType(q).IsEqual(identifierToType[q.Identifier]))
                                     .Select(q => new ComputedQuestionTypeConflict(
                                                        q,
                                                        q.Identifier.Name,
                                                        GetQuestionComputationType(q).GetString()));
        }
        private Types.Type GetQuestionComputationType(Question node)
        {
            var collector = new ExpressionTypeCollector(identifierToType);
            node.Computation.Accept(collector);

            if(Helper.ContainsError(collector.GetCollectedNotifications()))            
                return node.Computation.Accept(new ExpressionTypeCollector(identifierToType));

            return new Types.UndefinedType();
        }
        private IList<Expression> GetTopLevelExpressions()
        {
            return node.Accept(new TopLevelExpressionCollector());
        }

        private IEnumerable<INotification> Conditional_Expressions_Evaluate_To_Bool()
        {
            IList<Conditional> conditionals = node.Accept(new ConditionalCollector());

            foreach (Conditional conditional in conditionals)
            {
                if (!HasCorrectBooleanType(conditional, identifierToType))
                {
                    yield return new NonBooleanCondition(conditional.GetPosition());
                }
            }
        }

        private static bool HasCorrectBooleanType(Conditional node, Dictionary<Id, Types.Type> identifierToType)
        {
            var collector = new ExpressionTypeCollector(identifierToType);

            return node.Condition.Accept(collector).IsEqual(new Types.BoolType()) &&
                   !Helper.ContainsError(collector.GetCollectedNotifications());
        }

    }
}
