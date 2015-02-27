using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public class Result : Node, IStatement, IQuestionResult
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Result;
            }
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

        public Result(Identifier id, string label, TextPosition position)
            : base(position)
        {
            Id = id;
            Label = label;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

    }
}
