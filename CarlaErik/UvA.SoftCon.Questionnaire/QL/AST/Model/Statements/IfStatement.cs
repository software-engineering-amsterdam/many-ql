using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class IfStatement : QLNode, IStatement
    {
        public IExpression If
        {
            get;
            private set;
        }

        public ICollection<IStatement> Then
        {
            get;
            private set;
        }

        public ICollection<IStatement> Else
        {
            get;
            private set;
        }

        public IfStatement(IExpression @if, ICollection<IStatement> then, ICollection<IStatement> @else, TextPosition position)
            : base(position)
        {
            If = @if;
            Then = then;
            Else = @else;
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public void AppendQuestions(ICollection<Question> questions)
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
