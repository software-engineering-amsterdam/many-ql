using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Elements
{
    public class ElementBase
    {
        private string _id;
        private string _label;

        public string Id
        {
            get { return _id; }
            set { _id = value; }
        }
        public string Label
        {
            get { return _label; }
            set { _label = value; }
        }

        
    }
}
