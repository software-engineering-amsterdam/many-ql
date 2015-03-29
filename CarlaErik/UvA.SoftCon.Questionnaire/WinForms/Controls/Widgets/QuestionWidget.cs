using System;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    /// <remarks>
    /// Note that this class cannot be made abstract because as a control it has to inhertid from <see cref="System.Windows.Forms.UserControl"/>.
    /// Therefor all the would-be-marked abstract methods, are marked virtual instead with an exception in their body.
    /// </remarks>
    public partial class QuestionWidget : UserControl
    {
        public event EventHandler QuestionAnswered;

        protected Question Question
        {
            get;
            private set;
        }

        public string QuestionName
        {
            get
            {
                return Question.Name;
            }
        }

        public bool IsReadOnly
        {
            get
            {
                return Question.IsComputed;
            }
        }

        public QuestionWidget()
        {
            InitializeComponent();
        }

        protected QuestionWidget(Question astQuestion)
            : this()
        {
            Question = astQuestion;
        }

        public virtual void SetValue(Value value)
        {
            throw new NotImplementedException("This method must be overriden and implemented in the derived class.");
        }

        public virtual Value GetValue()
        {
            throw new NotImplementedException("This method must be overriden and implemented in the derived class.");
        }

        public virtual void ApplyStyles(StyleSet styleSet)
        {
            throw new NotImplementedException("This method must be overriden and implemented in the derived class.");
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
