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

                OutputTextBox.AppendText(report.ToString());

                if (report.NrOfErrors > 0)
                {
                    MessageBox.Show("Errors occured", "", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    SplitPanel.Panel2Collapsed = false;
                }
                else
                {
                    InitializeQuestionForm(form);
                }
            }
        }

        private void outputWindowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SplitPanel.Panel2Collapsed = !outputWindowToolStripMenuItem.Checked;
        }

        #endregion

        private void InitializeQuestionForm(QuestionForm form)
        {
            var uiBuilder = new DefaultUIBuilder();
            QuestionFormControl control = uiBuilder.BuildUi(form, Output);

            SplitPanel.Panel1.Controls.Add(control);
        }
    }
}
