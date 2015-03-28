using AST.Nodes;
using Notifications;

namespace AST
{
    public class ASTResult
    {
        public readonly Form RootNode;
        public INotificationManager NotificationManager { get; private set; }
        public ASTResult(Form tree, INotificationManager notificationManager)
        {
            RootNode = tree;
            NotificationManager = notificationManager;
        }

        public bool HasError()
        {
            return NotificationManager.HasError();
        }
    }
}
