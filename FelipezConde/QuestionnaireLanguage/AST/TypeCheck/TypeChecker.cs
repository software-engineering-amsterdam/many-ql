using AST.Nodes;
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
            IList<Identifier> usedIdentifiers            = GetUsedIdentifiers(node);
            Dictionary<string, IValue> identifierToType  = GetIdentifierTypes(node);
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

        private static IEnumerable<INotification> ConditionalsHaveTypeBool(Form node, Dictionary<string,IValue> identifierToType)
        {
            List<INotification> notifications = new List<INotification>();
            var conditionals = node.Accept(new ConditionalCollector());

            return conditionals.Where(c => 
                                        !DeriveConditionalType(c, identifierToType)
                                        .IsOfType(new Nodes.Values.Bool(true)))
                               .Select(c => new NonBooleanCondition(c.GetPosition()));
        }

        private static IEnumerable<INotification> CheckExpressionsHaveType(IList<IExpression> topLevelExpressions,Dictionary<string, IValue> identifierToType)
            {
                List<INotification> notifications = new List<INotification>();

                foreach (IExpression expr in topLevelExpressions)
                { 
                    var collector = new ExpressionTypeCollector(identifierToType);
                    notifications.AddRange(collector.GetCollectedNotifications());
                }

                return notifications;
            }
        private static IEnumerable<INotification> QuestionsHaveValidComputationType(IList<Question> definedIdentifiers, Dictionary<string, IValue> identifierToType)
        {
            return definedIdentifiers.Where( q => q.Computation != null)
                                     .Where( q => !DeriveQuestionType(q,identifierToType).IsOfType(identifierToType[q.Identifier]))
                                     .Select(q => new ComputedQuestionTypeConflict(
                                                        q,
                                                        q.Identifier, 
                                                        DeriveQuestionType(q, identifierToType).MakeString()));
        }

        private static IEnumerable<INotification> IdentifierChecks(
            Form node, 
            IList<Question> definedIdentifiers, 
            IList<Identifier> usedIdentifiers
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
                                (name, positions) => new { Name = name, Positions = positions }
                             )
                            .Where(occurrences => occurrences.Positions.Count() > 1)
                            .Select(x => new DuplicateIdentifier(x.Name, x.Positions));
        }

        private static IEnumerable<UndefinedIdentifier> GetUndefinedIdentifiers(IList<Question> definedIdentifiers, IList<Identifier> usedIdentifiers)
        {
            return usedIdentifiers
                    .Where(used => !definedIdentifiers.Any(defined => defined.Identifier == used.Name))
                    .Select(x => new UndefinedIdentifier(x.Node.GetPosition(), x.Name));
        }

        private static IList<Question> GetDefinedIdentifiers(Form node)
        { 
            return node.Accept(new DefinedIdentifierCollector()); 
        }
        private static IList<Identifier> GetUsedIdentifiers(Form node)
        { 
            return node.Accept(new UsedIdentifierCollector()); 
        }
        private static Dictionary<string, IValue> GetIdentifierTypes(Form node)
        {
           return node.Accept(new IdentifierTypeCollector())
                      .ToDictionary(x => x.name, x => x.type);
        }

        private static IList<IExpression> GetTopLevelExpressions(Form node)
        {
            return node.Accept(new TopLevelExpressionCollector());
        }
        private static IValue DeriveQuestionType(Question node, Dictionary<string, IValue> identifierToType)
        {
            return node.Computation.Accept(new ComputationTypeCollector(identifierToType));
        }

        private static IValue DeriveConditionalType(Conditional node, Dictionary<string, IValue> identifierToType)
        {
            return node.Condition.Accept(new ExpressionTypeCollector(identifierToType));
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
