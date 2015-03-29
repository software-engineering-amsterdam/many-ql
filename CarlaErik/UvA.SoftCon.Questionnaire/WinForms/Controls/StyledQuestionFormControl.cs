using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class StyledQuestionFormControl : UserControl
    {
        private QuestionForm _questionForm;
        private OutputWindow _outputWindow;

        public StyledQuestionFormControl()
        {
            InitializeComponent();
            Dock = DockStyle.Fill; // As it turns out, for user controls this property can not be set in the designer.
        }

        public StyledQuestionFormControl(QuestionForm form, IEnumerable<PageControl> pages, IEnumerable<QuestionWidget> questionControls, OutputWindow outputWindow)
            : this()
        {
            _questionForm = form;
            _outputWindow = outputWindow;

            foreach (var pageControl in pages)
            {
                pageControl.NavigateBackwards += PageControl_NavigateBackwards;
                pageControl.NavigateForwards += PageControl_NavigateForwards;

                // add 
            }
        }

        private void PageControl_NavigateBackwards(object sender, EventArgs e)
        {

        }

        private void PageControl_NavigateForwards(object sender, EventArgs e)
        {

        }
    }
}
