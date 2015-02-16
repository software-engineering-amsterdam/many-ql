using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Interfaces.Element
{
    public interface IElement
    {
        string Id { get; set; }

        string Label { get; set; }

        //This one to obtain the control
        Control GetControl();

        //This is to set the properties keyvalPair
        Control SetProperties(Dictionary<string,string> keyValue);
    }
}
