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

        private void AnswerTextBox_TextChanged(object sender, EventArgs e)
        {
            OnQuestionAnswered(new EventArgs());
        }
    }
}
