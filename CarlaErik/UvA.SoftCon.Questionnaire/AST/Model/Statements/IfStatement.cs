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

        public IfStatement(IExpression @if, ICollection<IStatement> then) 
        {
            If = @if;
            Then = then;
        }

        public IfStatement(IExpression @if, ICollection<IStatement> then, ICollection<IStatement> @else)
            : this(@if, then)
        {
            Else = @else;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
