using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class RadioWidget : QuestionWidget
    {
        public RadioWidget(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            TrueButton.Enabled = !astQuestion.IsComputed;
            FalseButton.Enabled = !astQuestion.IsComputed;
        }

        public RadioWidget(Question astQuestion, string trueLabel, string falseLabel)
            : this(astQuestion)
        {
            TrueButton.Text = trueLabel;
            FalseButton.Text = falseLabel;
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

        public override void ApplyStyles(StyleSet styleSet)
        {
            Font newFont = new Font(styleSet.FontName, styleSet.FontSize);
            System.Drawing.Color newColor = System.Drawing.Color.FromArgb(styleSet.FontColor.Red, styleSet.FontColor.Green, styleSet.FontColor.Blue);

            QuestionLabel.Font = newFont;
            QuestionLabel.ForeColor = newColor;
            TrueButton.Font = newFont;
            TrueButton.ForeColor = newColor;
            FalseButton.Font = newFont;
            FalseButton.ForeColor = newColor;
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
