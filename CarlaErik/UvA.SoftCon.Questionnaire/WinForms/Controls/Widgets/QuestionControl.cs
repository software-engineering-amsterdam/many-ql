using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class QuestionControl : UserControl
    {
        public event EventHandler QuestionAnswered;

        public string QuestionName
        {
            get;
            private set;
        }

        public string Label
        {
            get;
            private set;
        }

        public QuestionControl()
        {
            InitializeComponent();
        }

        protected QuestionControl(Question astQuestion)
            : this()
        {
            QuestionName = astQuestion.Id.Name;
            Label = astQuestion.Label;
        }

        public virtual void SetValue(Value value)
        {
            throw new NotImplementedException("This method must be overriden and implemented in the sub class.");
        }

        public virtual Value GetValue()
        {
            throw new NotImplementedException("This method must be overriden and implemented in the sub class.");
        }

        protected virtual void OnQuestionAnswered(EventArgs e)
        {
            EventHandler handler = QuestionAnswered;
            if (handler != null)
            {
                handler(this, e);
            }
        }
    }
}
