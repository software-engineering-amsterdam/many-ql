using System;
using System.Drawing;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class DropDownWidget : QuestionWidget
    {
        public DropDownWidget(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();

            QuestionLabel.Text = Label;
            YesNoDropDownBox.Enabled = !astQuestion.IsComputed;
        }

        public DropDownWidget(Question astQuestion, string trueLabel, string falseLabel)
            : this(astQuestion)
        {
        }

        public override Value GetValue()
        {
            if (YesNoDropDownBox.SelectedValue != null)
            {
                return new BooleanValue(YesNoDropDownBox.SelectedIndex == 1);
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
                    if (((BooleanValue)value).Val)
                    {
                        YesNoDropDownBox.SelectedText = "Yes";
                    }
                    else
                    {
                        YesNoDropDownBox.SelectedText = "No";
                    }
                }
                else
                {
                    throw new ArgumentException("Parameter value must be of datatype 'bool'.");
                }
            }
            else
            {
                YesNoDropDownBox.SelectedIndex = -1;
            }
        }

        public override void ApplyStyles(StyleSet styleSet)
        {
            QuestionLabel.Font = new Font(styleSet.FontName, styleSet.FontSize);
            QuestionLabel.ForeColor = System.Drawing.Color.FromArgb(styleSet.FontColor.Red, styleSet.FontColor.Green, styleSet.FontColor.Blue);
        }

        private void YesNoDropDownBox_SelectedValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
