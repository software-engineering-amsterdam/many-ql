using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class IfStatement : Statement
    {
        public Expression If
        {
            get;
            private set;
        }

        public IEnumerable<Statement> Then
        {
            get;
            private set;
        }

        public IEnumerable<Statement> Else
        {
            get;
            private set;
        }

        internal IfStatement(Expression @if, IEnumerable<Statement> then, IEnumerable<Statement> @else, TextPosition position)
            : base(position)
        {
            If = @if;
            Then = then;
            Else = @else;
        }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        internal override void CollectQuestions(ICollection<Question> questions)
        {
            foreach (var statement in Then)
            {
                statement.CollectQuestions(questions);
            }
            foreach (var statement in Else)
            {
                statement.CollectQuestions(questions);
            }
        }
    }
}
