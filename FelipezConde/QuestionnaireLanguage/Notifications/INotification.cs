using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications
{
    public interface INotification
    {
        string Message();
        bool IsError();
        bool IsWarning();
    }
}
