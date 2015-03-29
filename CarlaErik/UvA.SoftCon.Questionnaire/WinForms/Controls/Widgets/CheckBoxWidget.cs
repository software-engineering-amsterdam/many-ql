using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class CheckBoxWidget : QuestionWidget
    {
        public CheckBoxWidget(Question astQuestion)
            :base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            YesCheckBox.Enabled = !astQuestion.IsComputed;
        }

        public override Value GetValue()
        {
            return new BooleanValue(YesCheckBox.Checked);
        }

        public override void SetValue(Value value)
        {
            if (!value.IsUndefined)
            {
                if (value.DataType == DataType.Boolean)
                {
                    YesCheckBox.Checked = ((BooleanValue)value).Val; 
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
            YesCheckBox.Font = newFont;
            YesCheckBox.ForeColor = newColor;
        }

        private void YesCheckBox_CheckedChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
