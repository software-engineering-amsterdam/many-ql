using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Interfaces.Form
{
    public interface IForm
    {
      Control CreateForm(object type);
      Control CreateForm(string type);
    }
}
