using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class BooleanQuestion : UvA.SoftCon.Questionnaire.WinForms.Controls.QuestionControl
    {
        public BooleanQuestion(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            TrueButton.Enabled = !astQuestion.IsComputed;
            FalseButton.Enabled = !astQuestion.IsComputed;
        }

        private void TrueButton_CheckedChanged(object sender, EventArgs e)
        {
            SetAnswer();
            OnQuestionAnswered(new EventArgs());
        }

        private void FalseButton_CheckedChanged(object sender, EventArgs e)
        {
            SetAnswer();
            OnQuestionAnswered(new EventArgs());
        }

        private void SetAnswer() 
        {
            if (TrueButton.Checked)
            {
                Answer = new BooleanValue(true);
            }
            else if (FalseButton.Checked)
            {
                Answer = new BooleanValue(false);
            }
            else
            {
                Answer = new Undefined();
            }
        }

        protected override void SetControls()
        {
            if (!Answer.IsUndefined)
            {
                if (Answer.DataType == DataType.Boolean)
                {
                    bool answer = ((BooleanValue)Answer).Val;

                    TrueButton.Checked = answer;
                    FalseButton.Checked = !answer;
                }
                else
                {
                    throw new InvalidOperationException("Property Answer must be of datatype 'bool'.");
                }
            }
        }
    }
}
