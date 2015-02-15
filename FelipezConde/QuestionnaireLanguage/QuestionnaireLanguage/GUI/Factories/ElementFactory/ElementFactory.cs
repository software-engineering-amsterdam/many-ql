using QuestionnaireLanguage.GUI.Elements;
using QuestionnaireLanguage.GUI.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.GUI.Factories.ElementFactory
{
    internal static class ElementFactory
    {
        public static IElement GetElement(string type)
        {
            //string typeName = type.ToString();
            
            switch (type)
            {
                case "string":
                    return new TextBoxElement();
                default:
                    return new TextBoxElement();
            }

        }

        internal static TextBoxElement ObtainTextBox(string name, string label)
        {
            return new TextBoxElement(name, label);
        }
    }
}
