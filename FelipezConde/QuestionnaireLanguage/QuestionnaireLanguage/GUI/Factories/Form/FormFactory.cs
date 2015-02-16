using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QuestionnaireLanguage.GUI.Form;

namespace QuestionnaireLanguage.GUI.Factories.Form
{
    internal static class QuestionnaireFormFactory
    {
        internal static FormSection GetForm()
        {
            return new FormSection();
        }

        internal static Question GetQuestion(string type)
        {
            return new Question(type);
        }

        internal static Conditional GetConditional()
        {
            return new Conditional();
        }
    }
}
