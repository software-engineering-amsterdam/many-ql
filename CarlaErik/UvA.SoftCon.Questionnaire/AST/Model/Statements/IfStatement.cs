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

        public IReadOnlyList<IStatement> Then
        {
            get;
            private set;
        }

        public IReadOnlyList<IStatement> Else
        {
            get;
            private set;
        }

        public IfStatement(IExpression @if, IReadOnlyList<IStatement> then, TextPosition position)
            : base(position)
        {
            If = @if;
            Then = then;
            Else = new List<IStatement>();
        }

        public IfStatement(IExpression @if, IReadOnlyList<IStatement> then, IReadOnlyList<IStatement> @else, TextPosition position)
            : this(@if, then, position)
        {
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
