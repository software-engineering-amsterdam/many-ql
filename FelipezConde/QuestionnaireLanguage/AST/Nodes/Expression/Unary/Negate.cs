using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Expression.Unary
{
    public class Negate : ASTNode, IExpression, IUnary
    {
        private IExpression child;

        public Negate(IExpression child, PositionInText position)
            : base(position)
        {
            this.child = child;
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string GetParsedString()
        {
            throw new NotImplementedException();
        }

        public IExpression GetChildExpression()
        {
            return child;
        }
        public string MakeString()
        {
            return "!";
        }

        public IValue GetCompatibleType(Values.Bool ChildType)
        {
            return new Values.Bool(true);
        }

        public IValue GetCompatibleType(IValue rightType)
        {
            return new Values.Undefined();
        }
    }
}


