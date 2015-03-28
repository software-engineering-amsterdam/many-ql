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
    public partial class CalendarWidget : QuestionWidget
    {
        public CalendarWidget(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            AnswerDatePicker.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
        {
            return new DateValue(AnswerDatePicker.Value);
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Date)
                {
                    AnswerDatePicker.Value = ((DateValue)value).Val;
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'date'.");
                }
            }
        }

        private void AnswerDatePicker_ValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
