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
    public class IdentifierChecker
    {
        private readonly Form node;

        public IdentifierChecker(Form node)
        {
            this.node = node;
        }

        public INotificationManager AnalyzeAndReport()
        {
            return null;
        }

        private IEnumerable<INotification> Has_Duplicate_Identifiers()
        {
            List<Id> definedIdList = GetDefinedIdList(node);

            foreach (Id id  in definedIdList.GroupBy(s => s.Name).SelectMany(grp => grp.Skip(1)))
            {
                yield return new DuplicateIdentifier(id.Name, id.GetPosition());
            }
        }

        private IEnumerable<UndefinedIdentifier> Has_Undefined_Identifiers()
        {
            List<Id> definedIdList = GetDefinedIdList(node);

            foreach (FormObject formObject in node.GetBody())
            {
                definedIdList.AddRange(formObject.Accept(new DefinedIdentifierCollector()));
            }
        }

        private List<Id> GetDefinedIdList(Form node)
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
