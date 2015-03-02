using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public class OutputWindow
    {
        public TextBox TextBox
        {
            get;
            private set;
        }

        public OutputWindow(TextBox textBox)
        {
            TextBox = textBox;
        }

        public void WriteLine(string message)
        {
            TextBox.AppendText(message + "\r\n");
        }

        public void WriteLine(string format, params object[] args)
        {
            string message = String.Format(format, args);
            WriteLine(message);
        }
    }
}
