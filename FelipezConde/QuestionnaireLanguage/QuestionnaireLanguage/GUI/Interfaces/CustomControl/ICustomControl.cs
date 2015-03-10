using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.GUI.Interfaces.CustomControl
{
    public interface ICustomControl
    {
        IList<string> ListConditionalId { get; }

        void AddConditionalPanelId(string id);
    }
}
