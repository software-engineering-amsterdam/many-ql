using QuestionnaireLanguage.GUI.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Elements
{
    public class TextBoxElement : ElementBase, IElement
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
    }
}
