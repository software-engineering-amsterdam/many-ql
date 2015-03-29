using Notifications;

namespace QLGui.Controllers
{
    public class ErrorController
    {
        public INotificationManager NotificationManager { get; private set; }

        public ErrorController(INotificationManager notificationManager)
        {
            NotificationManager = notificationManager;
        }
    }
}
