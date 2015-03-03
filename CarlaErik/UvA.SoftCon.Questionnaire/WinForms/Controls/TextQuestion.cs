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
    public partial class TextQuestion : QuestionControl
    {
        public TextQuestion(Question astQuestion)
            : base(astQuestion)
        {
            InitializeComponent();
            QuestionLabel.Text = Label;
            AnswerTextBox.Enabled = !astQuestion.IsComputed;
        }

        private void AnswerTextBox_TextChanged(object sender, EventArgs e)
        {
            SetValue();
            OnQuestionAnswered(new EventArgs());
        }

        private void SetValue()
        {
            Answer = new StringValue(AnswerTextBox.Text);
        }

        protected override void SetControls()
        {
            if (!Answer.IsUndefined)
            {
                if (Answer.DataType == DataType.String)
                {
                    AnswerTextBox.Text = ((StringValue)Answer).Val;
                }
                else
                {
                    throw new InvalidOperationException("Property Answer must be of datatype 'string'.");
                }
            }
        }
    }
}
