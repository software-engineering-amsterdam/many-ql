using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

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

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        internal override void AppendQuestions(ICollection<Question> questions)
        {
            foreach (var statement in Then)
            {
                statement.AppendQuestions(questions);
            }
            foreach (var statement in Else)
            {
                statement.AppendQuestions(questions);
            }
        }
    }
}
