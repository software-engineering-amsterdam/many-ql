using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class Declaration : Node, IStatement
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

        public IExpression Initialization
        {
            get;
            private set;
        }

        public Declaration(DataType dataType, Identifier id, TextPosition position)
            : base(position)
        {
            DataType = dataType;
            Id = id;
        }

        public Declaration(DataType dataType, Identifier id, IExpression initialization, TextPosition position)
            : this(dataType, id, position)
        {
            Initialization = initialization;
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
