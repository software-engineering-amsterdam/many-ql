using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public class IfStatement : Node, IStatement
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.IfStatement;
            }
        }

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
