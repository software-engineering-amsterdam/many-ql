using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Input;
using Evaluation.Values;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public abstract class ObjectHandler
    {
        public virtual void CheckValidCharacter(object sender, TextCompositionEventArgs e) {}

        public abstract Value UpdateValue(object sender);

        public virtual bool IsValid(string text)
        {
            return true;
        }
    }
}
