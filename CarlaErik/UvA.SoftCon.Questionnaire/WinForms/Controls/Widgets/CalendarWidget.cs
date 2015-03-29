using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

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

        public override void ApplyStyles(StyleSet styleSet)
        {
            QuestionLabel.Font = new Font(styleSet.FontName, styleSet.FontSize);
            QuestionLabel.ForeColor = System.Drawing.Color.FromArgb(styleSet.FontColor.Red, styleSet.FontColor.Green, styleSet.FontColor.Blue);
        }

        private void AnswerDatePicker_ValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
