using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Interfaces.FormObject
{
    public interface IFormObject
    {
        UIElement ProcessFormObject(UIElement form);
    }
}
