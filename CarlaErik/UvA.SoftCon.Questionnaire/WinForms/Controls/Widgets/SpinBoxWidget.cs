using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class SpinBoxWidget : QuestionWidget
    {
        public SpinBoxWidget(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();

            AnswerUpDown.Value = 0;
            QuestionLabel.Text = Question.Label;
            AnswerUpDown.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
        {
            return new IntegerValue((int)AnswerUpDown.Value);
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Integer)
                {
                    AnswerUpDown.Value = ((IntegerValue)value).Val;
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'int'.");
                }
            }
        }

        public override void ApplyStyles(StyleSet styleSet)
        {
            QuestionLabel.Font = new Font(styleSet.FontName, styleSet.FontSize);
            QuestionLabel.ForeColor = System.Drawing.Color.FromArgb(styleSet.FontColor.Red, styleSet.FontColor.Green, styleSet.FontColor.Blue);
        }

        private void AnswerUpDown_ValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
