using System;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class SpinBoxWidget : QuestionWidget
    {
        public SpinBoxWidget(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();

            AnswerUpDown.Value = 0;
            QuestionLabel.Text = Label;
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

        private void AnswerUpDown_ValueChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
