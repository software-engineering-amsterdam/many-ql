
using Notifications;
namespace TypeChecking.Notifications.Warnings
{
    public abstract class Warning : INotification
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
