using System;
using System.Collections.Generic;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class QuestionFormControl : UserControl
    {
        private QuestionForm _questionForm;
        private OutputWindow _outputWindow;

        public QuestionFormControl()
        {
            InitializeComponent();
            Dock = DockStyle.Fill; // As it turns out, for user controls this property can not be set in the designer.
        }

        public QuestionFormControl(QuestionForm form, IEnumerable<QuestionWidget> questionWidgets, OutputWindow outputWindow)
            : this()
        {
            _questionForm = form;
            _outputWindow = outputWindow;

            foreach (var questionWidget in questionWidgets)
            {
                if (!questionWidget.IsReadOnly)
                {
                    questionWidget.QuestionAnswered += QuestionWidget_QuestionAnswered;
                }

                QuestionFlowLayout.Controls.Add(questionWidget);
            }

            Interpretet();
        }

        private void QuestionWidget_QuestionAnswered(object sender, EventArgs e)
        {
            Interpretet();
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

            foreach (QuestionWidget questionWidget in QuestionFlowLayout.Controls)
            {
                answers.Add(questionWidget.QuestionName, questionWidget.GetValue());
            }

            return answers;
        }

        private void SetResults(ValueTable results)
        {
            foreach (QuestionWidget questionWidget in QuestionFlowLayout.Controls)
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
        }
    }
}
