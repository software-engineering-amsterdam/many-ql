using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class SectionControl : UserControl
    {
        private IEnumerable<QuestionWidget> _questionWidgets;

        public SectionControl()
        {
            InitializeComponent();
        }

        internal SectionControl(string title, IEnumerable<QuestionWidget> questionsWidgets)
            : this()
        {
            SectionBox.Text = title;
            QuestionContainer.Controls.AddRange(questionsWidgets.ToArray());
            _questionWidgets = questionsWidgets;
        }

        public void SetResults(ValueTable results)
        {
            // We need to set the parent control to 'visible' before we can change the Visible property 
            // of any child controls.
            Visible = true;

            foreach (QuestionWidget questionWidget in _questionWidgets)
            {
                questionWidget.Visible = results.HasValue(questionWidget.QuestionName);

                if (results.HasValue(questionWidget.QuestionName))
                {
                    Value result = results.Get(questionWidget.QuestionName);

                    if (!result.IsUndefined)
                    {
                        questionWidget.SetValue(result);
                    }
                }
            }

            Visible = _questionWidgets.Any(widget => widget.Visible);
        }
    }
}
