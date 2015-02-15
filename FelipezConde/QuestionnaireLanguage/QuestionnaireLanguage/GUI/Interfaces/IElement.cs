using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Interfaces
{
    public interface IElement
    {
        string Id { get; set; }

        string Label { get; set; }
        Control GetControl();
    }
}
