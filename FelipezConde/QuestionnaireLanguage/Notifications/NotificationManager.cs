using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications
{
    public class NotificationManager : INotificationManager
    {
        private List<INotification> notifications = new List<INotification>();

        public void AddNotification(INotification notification)
        {
            notifications.Add(notification);
        }

        public bool HasError()
        {
            foreach (INotification notification in notifications)
            {
                if (notification.IsError())
                    return true;
            }
            return false;
        }

        public IList<INotification> GetNotifications()
        {
            return notifications;
        }
    }
}
