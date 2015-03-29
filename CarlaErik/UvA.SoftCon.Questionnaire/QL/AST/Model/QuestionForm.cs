using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class QuestionForm : QLNode
    {
        public IEnumerable<Statement> Statements
        {
            get;
            private set;
        }

        public QuestionForm(IEnumerable<Statement> statements, TextPosition position)
            : base(position)
        {
            Statements = statements;
        }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public IEnumerable<Question> GetAllQuestions()
        {
            var questions = new List<Question>();

            foreach (var statement in Statements)
            {
                statement.CollectQuestions(questions);
            }
            return questions;
        }
    }
}
