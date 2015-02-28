using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class TextQuestion : UvA.SoftCon.Questionnaire.WinForms.Controls.QuestionControl
    {
        public override string Label
        {
            get
            {
                return base.Label;
            }
            set
            {
                base.Label = value;
            }
        }

        public override Runtime.Evaluation.Types.Value Answer
        {
            get
            {
                return base.Answer;
            }
            set
            {
                base.Answer = value;
            }
        }

        public TextQuestion()
        {
            InitializeComponent();
        }

        private void AnswerTextBox_TextChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
