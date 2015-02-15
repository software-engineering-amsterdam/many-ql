using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.GUI.Form
{
    public class FormBase
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
