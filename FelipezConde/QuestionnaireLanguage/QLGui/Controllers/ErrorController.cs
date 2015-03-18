using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
