using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class StyledQuestionFormControl : UserControl
    {
        private IEnumerable<PageControl> _pages;
        private QuestionForm _questionForm;
        private IEnumerable<QuestionWidget> _questionWidgets;
        private OutputWindow _outputWindow;

        public StyledQuestionFormControl()
        {
            InitializeComponent();
            Dock = DockStyle.Fill; // As it turns out, for user controls this property can not be set in the designer.
        }

        public StyledQuestionFormControl(QuestionForm form, IEnumerable<PageControl> pages, IEnumerable<QuestionWidget> questionWidgets, OutputWindow outputWindow)
            : this()
        {
            _pages = pages;
            _questionForm = form;
            _questionWidgets = questionWidgets;
            _outputWindow = outputWindow;

            foreach (var pageControl in pages)
            {
                pageControl.NavigateBackwards += PageControl_NavigateBackwards;
                pageControl.NavigateForwards += PageControl_NavigateForwards;
            }

            foreach (var questionWidget in questionWidgets)
            {
                if (!questionWidget.IsReadOnly)
                {
                    questionWidget.QuestionAnswered += QuestionWidget_QuestionAnswered;
                }
            }

            // Paging is not yet supported. Only the first page is shown.
            Controls.Add(pages.First());
            Interpretet();
        }

        private void QuestionWidget_QuestionAnswered(object sender, EventArgs e)
        {
            Interpretet();
        }

        private void PageControl_NavigateBackwards(object sender, EventArgs e)
        {
        }

        private void PageControl_NavigateForwards(object sender, EventArgs e)
        {
        }

        private void Interpretet()
        {
            var runtimeController = new QL.Runtime.RuntimeController();
            var answers = CollectAnswers();

            try
            {
                var results = runtimeController.Interpretet(_questionForm, answers);

                SetResults(results);
            }
            catch (Exception ex)
            {
                _outputWindow.WriteLine("ERROR - {0}", ex.ToString());
                MessageBox.Show("Exception occured.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private ValueTable CollectAnswers()
        {
            var answers = new ValueTable();

            foreach (QuestionWidget questionWidget in _questionWidgets)
            {
                answers.Add(questionWidget.QuestionName, questionWidget.GetValue());
            }

            return answers;
        }

        private void SetResults(ValueTable results)
        {
            foreach (var page in _pages)
            {
                page.SetResults(results);
            }
        }
    }
}
