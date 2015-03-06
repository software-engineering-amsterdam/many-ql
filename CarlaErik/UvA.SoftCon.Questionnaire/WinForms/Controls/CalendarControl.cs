using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class CalendarControl : QuestionControl
    {
        public CalendarControl(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            AnswerDatePicker.Enabled = !astQuestion.IsComputed;
        }

        private void AnswerDatePicker_ValueChanged(object sender, EventArgs e)
        {
            SetAnswer();
            OnQuestionAnswered(new EventArgs());
        }

        private void SetAnswer() 
        {
            Answer = new DateValue(AnswerDatePicker.Value);
        }

        protected override void SetControls()
        {
            if (!Answer.IsUndefined)
            {
                if (Answer.DataType == DataType.Date)
                {
                    DateTime answer = ((DateValue)Answer).Val;

                    AnswerDatePicker.Value = answer;
                }
                else
                {
                    throw new InvalidOperationException("Property Answer must be of datatype 'date'.");
                }
            }
        }
    }
}
