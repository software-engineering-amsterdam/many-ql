using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Notification;
using AST.Notification.Errors;
using AST.Representation;
using AST.Storage;
using AST.TypeCheck.Collectors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.TypeCheck
{
    public static class TypeChecker
    {
        public static List<INotification> GetTypeCheckDiagnosis(Form node)
        {
            /*
             * TODO: Report error after every step
             */

            List<INotification> notifications = new List<INotification>(); 

            //Shared Type Information
            IList<Question> definedIdentifiers           = GetDefinedIdentifiers(node);
            IList<Id> usedIdentifiers                    = GetUsedIdentifiers(node);
            Dictionary<Id, Types.Type> identifierToType = GetIdentifierTypes(node);
            IList<IExpression> topLevelExpressions       = GetTopLevelExpressions(node);

            //Use of valid identifiers (unique and defined)
            notifications.AddRange(IdentifierChecks(node, definedIdentifiers, usedIdentifiers));

            //Top level expressions have a valid type
            notifications.AddRange(CheckExpressionsHaveType(topLevelExpressions, identifierToType));

            //Computed questions have valid type
            notifications.AddRange(QuestionsHaveValidComputationType(definedIdentifiers, identifierToType));

            //Conditionals expressions have type Boolean
            notifications.AddRange(ConditionalsHaveTypeBool(node, identifierToType));
            
            return notifications;
        }

        private static bool ContainsError(IList<INotification> notifications)
        {
            foreach (IError error in notifications)
            {
                return true;
            }

            return false;
        }

        private static IEnumerable<INotification> ConditionalsHaveTypeBool(Form node, Dictionary<Id, Types.Type> identifierToType)
        {
            IList<Conditional> conditionals = node.Accept(new ConditionalCollector());

            foreach (Conditional conditional in conditionals)
            {
                if (!HasCorrectType(conditional,identifierToType))
                {
                    yield return new NonBooleanCondition(conditional.GetPosition());
                }
            }

            //return conditionals.Where(c => 
            //                            !DeriveConditionalType(c, identifierToType)
            //                            .IsEqual(new Types.BoolType()))
            //                   .Select(c => new NonBooleanCondition(c.GetPosition()));
        }

        private static IEnumerable<INotification> CheckExpressionsHaveType(IList<IExpression> topLevelExpressions, Dictionary<Id, Types.Type> identifierToType)
            {
                List<INotification> notifications = new List<INotification>();

                foreach (IExpression expr in topLevelExpressions)
                {
                    ExpressionTypeCollector collector = new ExpressionTypeCollector(identifierToType);

                    expr.Accept(collector);

                    notifications.AddRange(collector.GetCollectedNotifications());
                }

                return notifications;
            }
        private static IEnumerable<INotification> QuestionsHaveValidComputationType(IList<Question> definedIdentifiers, Dictionary<Id, Types.Type> identifierToType)
        {
            return definedIdentifiers.Where( q => q.Computation != null)
                                     .Where( q => !DeriveQuestionType(q,identifierToType).IsEqual(identifierToType[q.Identifier]))
                                     .Select(q => new ComputedQuestionTypeConflict(
                                                        q,
                                                        q.Identifier.Name, 
                                                        DeriveQuestionType(q, identifierToType).GetString()));
        }

        private static IEnumerable<INotification> IdentifierChecks(
            Form node, 
            IList<Question> definedIdentifiers,
            IList<Id> usedIdentifiers
            )
        {
            List<INotification> notifications = new List<INotification>(); 

            notifications.AddRange( 
                GetUndefinedIdentifiers(definedIdentifiers, usedIdentifiers)
                );
            notifications.AddRange(
                GetDuplicateIdentifiers(definedIdentifiers)
                );
            
            return notifications;
        }

        private static IEnumerable<INotification> GetDuplicateIdentifiers(IList<Question> definedIdentifiers)
        {
            return definedIdentifiers
                            .GroupBy(
                                x => x.Identifier,
                                x => x.GetPosition(),
                                (id, positions) => new { Id = id, Positions = positions }
                             )
                            .Where(occurrences => occurrences.Positions.Count() > 1)
                            .Select(x => new DuplicateIdentifier(x.Id.Name, x.Positions));
        }

        private static IEnumerable<UndefinedIdentifier> GetUndefinedIdentifiers(IList<Question> definedIdentifiers, IList<Id> usedIdentifiers)
        {
            return usedIdentifiers
                    .Where(used => !definedIdentifiers.Any(defined => defined.Identifier.Name == used.Name))
                    .Select(x => new UndefinedIdentifier(x.GetPosition(), x.Name));
        }

        private static IList<Question> GetDefinedIdentifiers(Form node)
        { 
            return node.Accept(new QuestionCollector());
        }
        private static IList<Id> GetUsedIdentifiers(Form node)
        { 
            return node.Accept(new UsedIdentifierCollector()); 
        }
        private static Dictionary<Id, Types.Type> GetIdentifierTypes(Form node)
        {
           return node.Accept(new IdentifierTypeCollector())
                      .ToDictionary(id => id, id => id.RetrieveType());
        }

        private static IList<IExpression> GetTopLevelExpressions(Form node)
        {
            return node.Accept(new TopLevelExpressionCollector());
        }
        private static Types.Type DeriveQuestionType(Question node, Dictionary<Id, Types.Type> identifierToType)
        {
            return node.Computation.Accept(new ExpressionTypeCollector(identifierToType));
        }

        private static bool HasCorrectType(Conditional node, Dictionary<Id, Types.Type> identifierToType)
        {
            var collector = new ExpressionTypeCollector(identifierToType);
            
            return node.Condition.Accept(collector).IsEqual(new Types.BoolType()) &&
                   !ContainsError(collector.GetCollectedNotifications());

        }
        
        public static bool IsTypeCorrect(Form node)
        {
            //return false on the first error
            foreach(IError error in GetTypeCheckDiagnosis(node))
            {
                return false;
            }

            return true;
        }
    
    
    }
}
