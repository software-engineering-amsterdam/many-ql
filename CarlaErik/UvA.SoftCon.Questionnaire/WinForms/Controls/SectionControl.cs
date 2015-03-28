using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class SectionControl : UserControl
    {
        public SectionControl()
        {
            InitializeComponent();
        }

        internal SectionControl(string title, IEnumerable<QuestionWidget> questions)
            : this()
        {
            SectionBox.Text = title;
            QuestionContainer.Controls.AddRange(questions.ToArray());
        }
    }
}
