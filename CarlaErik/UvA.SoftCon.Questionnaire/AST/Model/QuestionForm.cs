using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire AST.
    /// </summary>
    public sealed class QuestionForm : Node
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Form;
            }
        }

        public ICollection<IStatement> Statements
        {
            get;
            private set;
        }

        public QuestionForm(ICollection<IStatement> statements, TextPosition position)
            : base(position)
        {
            Statements = statements;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public ICollection<Question> GetAllQuestions()
        {
            return GetAllQuestions(Statements);
        }

        private ICollection<Question> GetAllQuestions(ICollection<IStatement> statements)
        {
            var questions = new List<Question>();

            foreach (var statement in statements)
            {
                switch (statement.Type)
                {
                    case NodeType.Question:
                        questions.Add((Question)statement);
                        break;
                    case NodeType.IfStatement:
                        IfStatement ifStatement = (IfStatement)statement;
                        questions.AddRange(GetAllQuestions(ifStatement.Then));
                        questions.AddRange(GetAllQuestions(ifStatement.Else));
                        break;
                }
            }

            return questions;
        }
    }
}
