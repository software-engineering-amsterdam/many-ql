using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Nodes.Expression.Unary
{
    public class Priority : ASTNode, IExpression, IUnary
    {
        private IExpression expression;
        public Priority(IExpression child, PositionInText position)
            : base(position)
        {
            this.expression = child;
        }

        //Visitor methods
        public T Accept<T>(Visitors.IVisitor<T> visitor)
        { return visitor.Visit(this); }

        public void Accept(Visitors.IVisitor visitor)
        { visitor.Visit(this); }

        public IExpression GetChildExpression()
        {
            return expression;
        }
        public string MakeString()
        {
            return "()";
        }
    }
}
