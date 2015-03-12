using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using AST.Notification;
using AST.Notification.Errors;
using AST.TypeCheck.Collectors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.TypeCheck
{
    public static class Helper
    {
        public static Dictionary<Id, Types.Type> GetIdentifierTypes(Form node)
        {
           return node.Accept(new IdentifierTypeCollector()).ToDictionary(id => id, id => id.RetrieveType());
        }
        public static IList<Question> GetDefinedIdentifiers(Form node)
        {
            return node.Accept(new QuestionCollector());
        }

        public static bool ContainsError(IList<INotification> notifications)
        {
            foreach (IError error in notifications)
            {
                return true;
            }

            return false;
        }


    }
}
