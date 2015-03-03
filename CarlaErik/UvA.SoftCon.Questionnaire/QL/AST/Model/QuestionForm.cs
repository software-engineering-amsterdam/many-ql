using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class QuestionForm : Node
    {
        public ICollection<IStatement> Statements
        {
            get;
            private set;
        }

        public ICollection<Question> AllQuestions
        {
            get;
            private set;
        }

        public QuestionForm(ICollection<IStatement> statements, TextPosition position)
            : base(position)
        {
            Statements = statements;
            AllQuestions = GetAllQuestions();
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        private ICollection<Question> GetAllQuestions()
        {
            var questions = new List<Question>();

            foreach (var statement in Statements)
            {
                statement.AppendQuestions(questions);
            }
            return questions;
        }
    }
}
