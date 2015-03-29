using System.Collections.Generic;

namespace Notifications
{
    public interface INotificationManager
    {
        void AddNotification(INotification notification);

        void AddNotifications(IEnumerable<INotification> notifications);

        void Combine(INotificationManager notificationManager);
        bool HasError();
        IList<INotification> GetNotifications();
    }
}
