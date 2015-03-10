using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.Visitors
{
    public class CustomControlVisitor : ICustomControlVisitor
    {
        public ICustomControl Visit(TextBox control)
        {
        }
    }
}
