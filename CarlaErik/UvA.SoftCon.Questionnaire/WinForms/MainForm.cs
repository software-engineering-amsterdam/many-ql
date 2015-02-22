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

namespace WinForms
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }



        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog.ShowDialog();
        }

        private void OpenFileDialog_FileOk(object sender, CancelEventArgs e)
        {
            if (!e.Cancel)
            {
                var astController = new ASTController();
                var runtimeController = new RuntimeController();

                var qlFile = new FileInfo(OpenFileDialog.FileName);

                var form = astController.ParseQLFile(qlFile);

                var report = runtimeController.Validate(form);

                OutputTextBox.AppendText(report.GetReport());
            }
        }
    }
}
