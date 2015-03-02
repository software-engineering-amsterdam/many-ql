using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public class Assignment : Node, IStatement
    {
        public Identifier Variable
        {
            get;
            private set;
        }

        public IExpression Expression
        {
            get;
            private set;
        }

        public Assignment(Identifier variable, IExpression expression, TextPosition position)
            : base(position)
        {
            Variable = variable;
            Expression = expression;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public void AppendQuestions(ICollection<Question> questions)
        {
        }
    }
}
