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
    public partial class NumericQuestion : UvA.SoftCon.Questionnaire.WinForms.Controls.QuestionControl
    {
        public NumericQuestion(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();
            Answer = new IntegerValue(0); // Initialize this control with 0
            QuestionLabel.Text = Label;
        }

        private void AnswerUpDown_ValueChanged(object sender, EventArgs e)
        {
            SetValue();
            OnQuestionAnswered(new EventArgs());
        }

        private void SetValue()
        {
            Answer = new IntegerValue((int)AnswerUpDown.Value);
        }

        protected override void SetControls()
        {
            if (!Answer.IsUndefined)
            {
                if (Answer.DataType == DataType.Integer)
                {
                    AnswerUpDown.Value = ((IntegerValue)Answer).Val;
                }
                else
                {
                    throw new InvalidOperationException("Property Answer must be of datatype 'int'.");
                }
            }
        }
    }
}
