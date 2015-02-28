using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class NumericQuestion : UvA.SoftCon.Questionnaire.WinForms.Controls.QuestionControl
    {
        public NumericQuestion()
        {
            InitializeComponent();
        }

        private void AnswerUpDown_ValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
