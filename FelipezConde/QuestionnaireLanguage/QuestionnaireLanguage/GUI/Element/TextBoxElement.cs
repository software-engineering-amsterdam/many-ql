using QuestionnaireLanguage.GUI.Interfaces.Element;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Elements
{
    public class TextBoxElement : ElementBase, ITextBoxElement
    {
        public TextBoxElement(string id, string label)
        {
            Id = id;
            Label = label;
        }

        public TextBoxElement()
        {

        }

        public Control GetControl()
        {
            TextBox textBox = new TextBox() { Name = Id, Text = Label };

            CheckBox c = new CheckBox();
            
            return textBox;
        }

        public Control SetProperties(Dictionary<string, string> keyValue)
        {
            return null;
        }
    }
}
