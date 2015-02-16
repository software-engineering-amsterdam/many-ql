using QuestionnaireLanguage.GUI.Elements;
using QuestionnaireLanguage.GUI.Interfaces.Element;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.GUI.Factories.Element
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

        internal static TextBoxElement GetTextBox(string name, string label)
        {
            return new TextBoxElement(name, label);
        }
    }
}
