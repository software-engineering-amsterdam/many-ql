using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class PageControl : UserControl
    {
        private IEnumerable<SectionControl> _sections;

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
            _sections = sections;
            SectionContainer.Controls.AddRange(sections.ToArray());
        }

        public void SetResults(IDictionary<string, Value> results)
        {
            foreach (var section in _sections)
            {
                section.SetResults(results);
            }
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
