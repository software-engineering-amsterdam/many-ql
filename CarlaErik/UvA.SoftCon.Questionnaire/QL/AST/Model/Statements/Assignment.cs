using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class Assignment : QLNode, IStatement
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

        internal Assignment(Identifier variable, IExpression expression, TextPosition position)
            : base(position)
        {
            Variable = variable;
            Expression = expression;
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
        }
    }
}
