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
    public class Question : Statement
    {
        public DataType DataType
        {
            get;
            private set;
        }

        public Identifier Id
        {
            get;
            private set;
        }

        public string Label
        {
            get;
            private set;
        }

        public Expression Expression
        {
            get;
            private set;
        }

        public bool IsComputed
        {
            get
            {
                return Expression != null;
            }
        }

        internal Question(DataType dataType, Identifier id, string label, TextPosition position)
            : base(position)
        {
            DataType = dataType;
            Id = id;
            Label = label;
            Expression = null;
        }

        internal Question(DataType dataType, Identifier id, string label, Expression expression, TextPosition position)
            : this(dataType, id, label, position)
        {
            Expression = expression;
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        internal override void AppendQuestions(ICollection<Question> questions)
        {
            questions.Add(this);
        }
    }
}
