using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class RadioControl : QuestionControl
    {
        public RadioControl(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            TrueButton.Enabled = !astQuestion.IsComputed;
            FalseButton.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
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

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Boolean)
                {
                    bool answer = ((BooleanValue)value).Val;

                    TrueButton.Checked = answer;
                    FalseButton.Checked = !answer;
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'bool'.");
                }
            }
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
