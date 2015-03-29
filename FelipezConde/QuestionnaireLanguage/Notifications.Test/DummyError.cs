using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications.Test
{
    public class DummyError : INotification
    {
        public string Message()
        {
            return "This is a DummyError";
        }

        public bool IsError()
        {
            return true;
        }
    }
}
