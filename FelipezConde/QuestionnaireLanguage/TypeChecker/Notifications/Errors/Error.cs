using Notifications;

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
