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
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    public partial class QuestionControl : UserControl
    {
        private Value _answer;

        public event EventHandler QuestionAnswered;

        public string QuestionName
        {
            get;
            protected set;
        }

        public string Label
        {
            get;
            protected set;
        }

        public Value Answer
        {
            get
            {
                return _answer;
            }
            set
            {
                _answer = value;
                SetControls();
            }
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
            Answer = new Undefined();
        }

        protected virtual void SetControls()
        {

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
