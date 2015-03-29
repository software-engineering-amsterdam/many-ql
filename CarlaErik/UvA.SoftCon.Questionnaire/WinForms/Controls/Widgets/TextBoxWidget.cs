using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class TextBoxWidget : QuestionWidget
    {
        public TextBoxWidget(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            AnswerTextBox.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
        {
            return new StringValue(AnswerTextBox.Text);
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.String)
                {
                    AnswerTextBox.Text = ((StringValue)value).Val;
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'string'.");
                }
            }
        }

        public override void ApplyStyles(StyleSet styleSet)
        {
            QuestionLabel.Font = new Font(styleSet.FontName, styleSet.FontSize);
            QuestionLabel.ForeColor = System.Drawing.Color.FromArgb(styleSet.FontColor.Red, styleSet.FontColor.Green, styleSet.FontColor.Blue);
        }

        private void AnswerTextBox_TextChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
