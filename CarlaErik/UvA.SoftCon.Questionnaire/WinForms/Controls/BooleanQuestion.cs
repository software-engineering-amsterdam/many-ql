using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class BooleanQuestion : UvA.SoftCon.Questionnaire.WinForms.Controls.QuestionControl
    {
        public override string Label
        {
            get
            {
                return QuestionLabel.Text;
            }
            set
            {
                QuestionLabel.Text = value;
            }
        }

        public override Value Answer
        {
            get
            {
                if (TrueButton.Checked)
                {
                    return new BooleanValue(true);
                }
                else if (FalseButton.Checked)
                {
                    return new BooleanValue(false);
                }
                else
                {
                    return new Undefined();
                }
            }
        }

        public BooleanQuestion()
        {
            InitializeComponent();
        }

        public BooleanQuestion(string label)
        {
            Label = label;
        }

        private void TrueButton_CheckedChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }

        private void FalseButton_CheckedChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
