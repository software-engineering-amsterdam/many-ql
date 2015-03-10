using QuestionnaireLanguage.GUI.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.FormObject;

namespace QuestionnaireLanguage.GUI.Factories.FormObjects
{
    internal static class FormObjectFactory
    {
        internal static QuestionObject GetFormObject(Question node)
        {
            return new QuestionObject(node);
        }

        internal static ConditionalObject GetFormObject(Conditional node)
        {
            return new ConditionalObject(node);
        }
    }
}
