using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecking
{
    public class LabelChecker : IFormObjectVisitor<INotificationManager>
    {
        public INotificationManager AnalyzeAndReport(IList<FormObject> body)
        {
            INotificationManager notificationManager = Has_Duplicate_Identifiers(node);

            foreach (FormObject formObject in body)
            {
                notificationManager.Combine(formObject.Accept(this));
            }

            notificationManager.Combine(Has_Undefined_Identifiers(node));

            return notificationManager;
        }

        public INotificationManager Visit(AST.Nodes.FormObjects.Conditional conditional)
        {
            throw new NotImplementedException();
        }

        public INotificationManager Visit(AST.Nodes.FormObjects.Question question)
        {
            throw new NotImplementedException();
        }

        private static List<Id> GetDefinedIdList(Form node)
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
