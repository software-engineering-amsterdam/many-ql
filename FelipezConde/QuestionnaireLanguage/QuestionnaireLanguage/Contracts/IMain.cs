using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.Contracts
{
    public interface IMain
    {
        UIElementCollection GetControls();
        UIElement GetRootElement();
        void DeleteElements();
        void SetFocus(IInputElement inputElement);
    }
}
