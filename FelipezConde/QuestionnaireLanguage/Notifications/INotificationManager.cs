using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications
{
    public interface INotificationManager
    {
        void AddNotification(INotification notification);
        INotificationManager Combine(INotificationManager notificationManager);
        bool HasError();
        IList<INotification> GetNotifications();
    }
}
