using System;
using System.Collections.Generic;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
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

        public QuestionFormControl(QuestionForm form, IEnumerable<QuestionWidget> questionControls, OutputWindow outputWindow)
            : this()
        {
            _questionForm = form;
            _outputWindow = outputWindow;

            foreach (var questionControl in questionControls)
            {
                questionControl.QuestionAnswered += QuestionWidget_QuestionAnswered;

                AddControl(questionControl);
            }

            Interpretet();
        }

        protected void AddControl(Control control)
        {
            QuestionFlowLayout.Controls.Add(control);
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

        private IDictionary<string, Value> CollectAnswers()
        {
            var answers = new Dictionary<string, Value>();

            foreach (QuestionWidget questionWidget in QuestionFlowLayout.Controls)
            {
                answers.Add(questionWidget.QuestionName, questionWidget.GetValue());
            }

            return answers;
        }

        private void SetResults(IDictionary<string, Value> results)
        {
            foreach (QuestionWidget questionWidget in QuestionFlowLayout.Controls)
            {
                questionWidget.Visible = results.ContainsKey(questionWidget.QuestionName);

                if (results.ContainsKey(questionWidget.QuestionName))
                {
                    Value result = results[questionWidget.QuestionName];

                    if (!result.IsUndefined)
                    {
                        questionWidget.SetValue(result);
                    }
                }
            }
        }
    }
}
