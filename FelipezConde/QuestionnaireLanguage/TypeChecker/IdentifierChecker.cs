using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using Notifications;
using System.Collections.Generic;
using System.Linq;
using TypeChecker.Collectors;
using TypeChecker.Notifications.Errors;

namespace TypeChecker
{
    public class IdentifierChecker
    {
        private readonly Form node;
        private readonly IList<Question> definedIdentifiers;
        private readonly IList<Id> usedIdentifiers;

        public IdentifierChecker(Form node)
        {
            this.node = node;
            this.definedIdentifiers = Helper.GetDefinedIdentifiers(node);
            this.usedIdentifiers = GetUsedIdentifiers(); 
        }

        public IEnumerable<INotification> AnalyzeAndReport()
        {
            List<INotification> notifications = new List<INotification>();

            notifications.AddRange(Has_Undefined_Identifiers());
            notifications.AddRange(Has_Duplicate_Identifiers());

            return notifications;
        }

        private IEnumerable<INotification> Has_Duplicate_Identifiers()
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

        private IEnumerable<UndefinedIdentifier> Has_Undefined_Identifiers()
        {
            return usedIdentifiers
                    .Where(used => !definedIdentifiers.Any(defined => defined.Identifier.Name == used.Name))
                    .Select(x => new UndefinedIdentifier(x.GetPosition(), x.Name));
        }

        private IList<Id> GetUsedIdentifiers()
        {
            return node.Accept(new UsedIdentifierCollector());
        }
    }
}
