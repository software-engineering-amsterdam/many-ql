using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecker.Notifications.Errors
{
    public abstract class Error : INotification
    {
        public bool IsError()
        {
            return true;
        }

        public bool IsWarning()
        {
            return false;
        }

        public abstract string Message();
    }
}
