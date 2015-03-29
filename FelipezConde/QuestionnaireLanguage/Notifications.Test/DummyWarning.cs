using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications.Test
{
    public class DummyWarning : INotification
    {
        public string Message()
        {
            return "this is a dummy Message";
        }

        public bool IsError()
        {
            return false;
        }
    }
}
