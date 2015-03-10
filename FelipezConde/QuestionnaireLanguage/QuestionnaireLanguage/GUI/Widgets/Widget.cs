using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class Widget : IWidget
    {
        private string _id;

        public string Id
        {
            get { return _id; }
            set { _id = value; }
        }

        public abstract UIElement CreateUIControl();
    }
}
