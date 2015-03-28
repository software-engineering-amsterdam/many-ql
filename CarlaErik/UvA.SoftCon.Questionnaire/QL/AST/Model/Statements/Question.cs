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
    public abstract class Question : Statement
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

        public string Name
        {
            get
            {
                return Id.Name;
            }
        }

        public bool IsComputed
        {
            get
            {
                return Expression != null;
            }
        }

        protected Question(DataType dataType, Identifier id, string label, Expression expression, TextPosition position)
            : base(position)
        {
            DataType = dataType;
            Id = id;
            Label = label;
            Expression = expression;
        }

        internal override void CollectQuestions(ICollection<Question> questions)
        {
            questions.Add(this);
        }
    }
}
