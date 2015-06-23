using System;
using System.ComponentModel;
using System.IO;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.WinForms.Controls;
using UvA.SoftCon.Questionnaire.WinForms.UIBuilding;

namespace UvA.SoftCon.Questionnaire.WinForms
{
    public partial class MainForm : Form
    {
        protected OutputWindow Output
        {
            get;
            private set;
        }

        public MainForm()
        {
            InitializeComponent();
            Output = new OutputWindow(OutputTextBox);
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

        private void closeFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SplitPanel.Panel1.Controls.Clear();
        }

        private void OpenQLFileDialog_FileOk(object sender, CancelEventArgs e)
        {
            if (!e.Cancel)
            {
                var qlFile = new FileInfo(OpenQLFileDialog.FileName);
                var qlsFile = new FileInfo(qlFile.FullName + "s");

                if (qlsFile.Exists)
                {
                    InitializeQuestionnaire(qlFile, qlsFile);
                }
                else
                {
                    InitializeQuestionnaire(qlFile);
                }
            }
        }

        private void outputWindowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SplitPanel.Panel2Collapsed = !outputWindowToolStripMenuItem.Checked;
        }

        #endregion

        #region Default Questionnaire

        private void InitializeQuestionnaire(FileInfo qlFile)
        {
            try
            {
                var form = ParseQLFile(qlFile);
                var report = ValidateQuestionForm(form);

                OutputTextBox.AppendText(report.ToString());

                if (report.NrOfErrors == 0)
                {
                    var ui = BuildUI(form);
                    SplitPanel.Panel1.Controls.Add(ui);
                }
                else
                {
                    MessageBox.Show("Validation errors in the questionnaire AST. See Output Window for details."
                        , "Validation errors", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    SplitPanel.Panel2Collapsed = false;
                }
            }
            catch (Exception ex)
            {
                Output.WriteLine("ERROR - {0}", ex.ToString());
                MessageBox.Show("Exception occured. See Output Window for details.", "Unhandled exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private QuestionForm ParseQLFile(FileInfo qlFile)
        {
            try
            {
                var qlController = new QLController();
                return qlController.ParseQLFile(qlFile);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during parsing of the QL file.", ex);
            }
        }

        private ValidationReport ValidateQuestionForm(QuestionForm form)
        {
            try
            {
                var runtimeController = new QL.Runtime.RuntimeController();
                return runtimeController.Validate(form);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during the validation of the questionnaire AST.", ex);
            }
        }

        private QuestionFormControl BuildUI(QuestionForm form)
        {
            try
            {
                var uiBuilder = new DefaultUIBuilder();
                return uiBuilder.BuildUI(form, Output);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during creating of the user interface.", ex);
            }
        }

        #endregion

        #region Styled Questionnaire

        private void InitializeQuestionnaire(FileInfo qlFile, FileInfo qlsFile)
        {
            try
            {
                var form = ParseQLFile(qlFile);
                var styleSheet = ParseQLSFile(qlsFile);

                var qlReport = ValidateQuestionForm(form);
                OutputTextBox.AppendText(qlReport.ToString());

                var qlsReport = ValidateStyleSheet(styleSheet, form);
                OutputTextBox.AppendText(qlsReport.ToString());

                if (qlReport.NrOfErrors == 0 && qlsReport.NrOfErrors == 0)
                {
                    QuestionStyleCollection questionStyles = GetQuestionStyles(styleSheet, form);

                    var ui = BuildUI(styleSheet, questionStyles, form);
                    SplitPanel.Panel1.Controls.Add(ui);
                }
                else
                {
                    MessageBox.Show("Validation errors in the questionnaire and/or style sheet AST. See Output Window for details."
                        , "Validation errors", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    SplitPanel.Panel2Collapsed = false;
                }
            }
            catch (Exception ex)
            {
                Output.WriteLine("ERROR - {0}", ex.ToString());
                MessageBox.Show("Exception occured. See Output Window for details.", "Unhandled exception", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private StyleSheet ParseQLSFile(FileInfo qlsFile)
        {
            try
            {
                var qlsController = new QLSController();
                return qlsController.ParseQLSFile(qlsFile);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during parsing of the QLS file.", ex);
            }
        }

        private ValidationReport ValidateStyleSheet(StyleSheet styleSheet, QuestionForm form)
        {
            try
            {
                var runtimeController = new QLS.Runtime.RuntimeController();
                return runtimeController.Validate(styleSheet, form);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during the validation of the style sheet AST.", ex);
            }
        }

        private QuestionStyleCollection GetQuestionStyles(StyleSheet styleSheet, QuestionForm form)
        {
            try
            {
                var runtimeController = new QLS.Runtime.RuntimeController();
                return runtimeController.GetQuestionStyles(styleSheet, form);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during the evaluation of the question styles.", ex);
            }
        }

        private Control BuildUI(StyleSheet styleSheet, QuestionStyleCollection questionStyles, QuestionForm form)
        {
            try
            {
                var uiBuilder = new StyleSheetUIBuilder();
                return uiBuilder.BuildUI(styleSheet, questionStyles, form, Output);
            }
            catch (Exception ex)
            {
                throw new ApplicationException("An unexpected error occured during creating of the styled user interface.", ex);
            }
        }

        #endregion
    }
}
