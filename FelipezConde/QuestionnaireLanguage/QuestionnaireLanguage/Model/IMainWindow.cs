using System.Windows;

namespace QuestionnaireLanguage.Contracts
{
    public interface IMainWindow
    {
        UIElement GetRootElement();
        void DeleteElements();
    }
}
