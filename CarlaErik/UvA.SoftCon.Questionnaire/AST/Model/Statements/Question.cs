using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public class Question : Node, IStatement
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

        public Question(DataType dataType, Identifier id, string label)
        {
            DataType = dataType;
            Id = id;
            Label = label;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
