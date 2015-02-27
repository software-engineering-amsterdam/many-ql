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
using UvA.SoftCon.Questionnaire.AST;
using UvA.SoftCon.Questionnaire.Runtime;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace WinForms
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


        public void InitializeQuestions()
        {
        }



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
                

                var astController = new ASTController();
                var runtimeController = new RuntimeController();

                var form = astController.ParseQLFile(qlFile);

                var report = runtimeController.Validate(form);

                OutputTextBox.AppendText(report.GetReport());

                if (report.NrOfWarnings + report.NrOfErrors > 0)
                {
                    MessageBox.Show("Errors occured", "", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    SplitPanel.Panel2Collapsed = false;
                }
            }
        }

        private void outputWindowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SplitPanel.Panel2Collapsed = !outputWindowToolStripMenuItem.Checked;
        }


    }
}
