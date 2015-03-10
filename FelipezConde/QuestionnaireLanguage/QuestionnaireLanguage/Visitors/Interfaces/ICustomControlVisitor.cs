using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ICustomControlVisitor
    {
        ICustomControl Visit(TextBox control);
    }
}
