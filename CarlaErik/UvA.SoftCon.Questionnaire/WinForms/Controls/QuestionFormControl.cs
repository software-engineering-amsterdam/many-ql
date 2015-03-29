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
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class QuestionFormControl : UserControl
    {
        protected QuestionForm QuestionForm
        {
            get;
            private set;
        }

        protected OutputWindow Output
        {
            get;
            private set;
        }

        public QuestionFormControl()
        {
            InitializeComponent();
            Dock = DockStyle.Fill; // As it turns out, for user controls this property can not be set in the designer.
        }

        public QuestionFormControl(QuestionForm form, IEnumerable<QuestionWidget> questionControls, OutputWindow outputWindow)
            : this()
        {
            QuestionForm = form;
            Output = outputWindow;

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
                var results = runtimeController.Interpretet(QuestionForm, answers);

                SetResults(results);
            }
            catch (Exception ex)
            {
                Output.WriteLine("ERROR - {0}", ex.ToString());
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
            foreach (QuestionWidget uiQuestion in QuestionFlowLayout.Controls)
            {
                uiQuestion.Visible = results.ContainsKey(uiQuestion.QuestionName);

                if (results.ContainsKey(uiQuestion.QuestionName))
                {
                    Value result = results[uiQuestion.QuestionName];

                    if (!result.IsUndefined)
                    {
                        uiQuestion.SetValue(result);
                    }
                }
            }
        }
    }
}
