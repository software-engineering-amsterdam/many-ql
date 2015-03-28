using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public class StyledQuestionFormControl : QuestionFormControl
    {
        public StyledQuestionFormControl(QuestionForm form, IEnumerable<PageControl> pages, IEnumerable<QuestionWidget> questionControls, OutputWindow outputWindow)
            : base(form, questionControls, outputWindow)
        {

            foreach (var pageControl in pages)
            {
                pageControl.NavigateBackwards += PageControl_NavigateBackwards;
                pageControl.NavigateForwards += PageControl_NavigateForwards;

                AddControl(pageControl);
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
