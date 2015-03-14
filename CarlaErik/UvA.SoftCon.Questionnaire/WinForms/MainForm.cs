using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms
{
    public partial class MainForm : Form
    {
        protected OutputWindow Output
        {
            get;
            private set;
        }

        protected QuestionForm QuestionForm
        {
            get;
            private set;
        }

        public MainForm()
        {
            InitializeComponent();
            Output = new OutputWindow(OutputTextBox);
        }

        public void InitializeQuestions()
        {
            QuestionFlowLayout.Controls.Clear();

            var runtimeController = new RuntimeController();

            foreach (var astQuestion in QuestionForm.AllQuestions)
            {
                QuestionControl uiQuestion = CreateQuestionWidget(astQuestion);

                if (!astQuestion.IsComputed)
                {
                    uiQuestion.QuestionAnswered += uiQuestion_QuestionAnswered;
                }

                QuestionFlowLayout.Controls.Add(uiQuestion);
                Output.WriteLine("Question added: {0}, \"{1}\"", astQuestion.Id.Name, astQuestion.Label);
            }
        }

        private void uiQuestion_QuestionAnswered(object sender, EventArgs e)
        {
            Interpretet();
        }

        public void Interpretet()
        {
            var runtimeController = new RuntimeController();
            var answers = GetAnswers();

            try
            {
                var visibleQuestions =  runtimeController.Interpretet(QuestionForm, answers);

                foreach (QuestionControl uiQuestion in QuestionFlowLayout.Controls)
                {
                    uiQuestion.Visible = visibleQuestions.ContainsKey(uiQuestion.QuestionName);

                    if (visibleQuestions.ContainsKey(uiQuestion.QuestionName))
                    {
                        Value result = visibleQuestions[uiQuestion.QuestionName];

                        if (!result.IsUndefined)
                        {
                            uiQuestion.SetValue(result);
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                Output.WriteLine("ERROR - {0}", ex.ToString());
                MessageBox.Show("Exception occured.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private IDictionary<string, Value> GetAnswers()
        {
            var answers = new Dictionary<string, Value>();

            foreach (QuestionControl uiQuestion in QuestionFlowLayout.Controls)
            {
                answers.Add(uiQuestion.QuestionName, uiQuestion.GetValue());
            }

            return answers;
        }

        #region Event Handlers

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenQLFileDialog.ShowDialog();
        }

        private void OpenQLFileDialog_FileOk(object sender, CancelEventArgs e)
        {
            if (!e.Cancel)
            {
                var qlFile = new FileInfo(OpenQLFileDialog.FileName);

                Output.WriteLine("------ Parsing started: QL File: {0} ------", qlFile.Name);
                
                var qlController = new QLController();
                var runtimeController = new RuntimeController();

                var form = qlController.ParseQLFile(qlFile);

                var report = runtimeController.Validate(form);

                OutputTextBox.AppendText(report.GetReport());

                if (report.NrOfErrors > 0)
                {
                    MessageBox.Show("Errors occured", "", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    SplitPanel.Panel2Collapsed = false;
                }
                else
                {
                    QuestionForm = form;
                    
                    InitializeQuestions();
                    Interpretet();
                }
            }
        }

        private void outputWindowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SplitPanel.Panel2Collapsed = !outputWindowToolStripMenuItem.Checked;
        }

        #endregion

        private QuestionControl CreateQuestionWidget(Question question)
        {
            QuestionControl questionWidget;

            switch (question.DataType)
            {
                case DataType.Boolean:
                    questionWidget = new RadioControl(question);
                    break;
                case DataType.Integer:
                    questionWidget = new SpinBoxControl(question);
                    break;
                case DataType.String:
                    questionWidget = new TextBoxControl(question);
                    break;
                case DataType.Date:
                    questionWidget = new CalendarControl(question);
                    break;
                default:
                    throw new NotSupportedException();
            }

            questionWidget.Visible = false;

            return questionWidget;
        }
    }
}
