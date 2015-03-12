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
            List<INotification> notifications = new List<INotification>(); 

            notifications.AddRange(new IdentifierChecker(node).GetDiagnosis());
            notifications.AddRange(new ExpressionChecker(node).GetDiagnosis());
            //TODO: Add Cyclic dependency check

            return notifications;
        }

        public static bool IsTypeCorrect(Form node)
        {
            return Helper.ContainsError(GetTypeCheckDiagnosis(node));
        }

    }
}
