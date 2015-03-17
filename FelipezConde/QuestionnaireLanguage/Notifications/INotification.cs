
namespace Notifications
{
    public interface INotification
    {
        string Message();
        bool IsError();
    }
}
