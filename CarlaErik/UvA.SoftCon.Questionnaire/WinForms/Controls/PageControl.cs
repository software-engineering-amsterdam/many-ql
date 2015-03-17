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
    public partial class PageControl : UserControl
    {
        public PageControl()
        {
            InitializeComponent();
        }

        internal PageControl(IEnumerable<SectionControl> sections)
            : this()
        {
            SectionContainer.Controls.AddRange(sections.ToArray());
        }
    }
}
