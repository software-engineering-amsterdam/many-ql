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
        public event EventHandler NavigateBackwards;
        public event EventHandler NavigateForwards;

        public PageControl()
        {
            InitializeComponent();
            Dock = DockStyle.Fill; // As it turns out, for user controls this property can not be set in the designer.
        }

        internal PageControl(IEnumerable<SectionControl> sections)
            : this()
        {
            SectionContainer.Controls.AddRange(sections.ToArray());
        }


        protected virtual void OnNavigateBackwards(EventArgs e)
        {
            EventHandler handler = NavigateBackwards;
            if (handler != null)
            {
                handler(this, e);
            }
        }

        protected virtual void OnNavigateForwards(EventArgs e)
        {
            EventHandler handler = NavigateForwards;
            if (handler != null)
            {
                handler(this, e);
            }
        }


        private void PreviousButton_Click(object sender, EventArgs e)
        {
            OnNavigateBackwards(new EventArgs());
        }

        private void NextButton_Click(object sender, EventArgs e)
        {
            OnNavigateForwards(new EventArgs());
        }
    }
}
