using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class QuestionForm : QLNode
    {
        public IEnumerable<IStatement> Statements
        {
            get;
            private set;
        }

        public IEnumerable<Question> AllQuestions
        {
            get;
            private set;
        }

        public QuestionForm(IEnumerable<IStatement> statements, TextPosition position)
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

        private IEnumerable<Question> GetAllQuestions()
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
