using Notifications;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecker.Notifications.Warnings
{
    public abstract class Warning : IWarning
    {
        public bool IsError()
        {
            return false;
        }

        public bool IsWarning()
        {
            return true;
        }

        public abstract string Message();
    }
}
