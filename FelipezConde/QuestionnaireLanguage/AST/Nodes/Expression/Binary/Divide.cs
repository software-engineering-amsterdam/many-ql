using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Expression.Binary
{
    public class Divide : ASTNode, IExpression, IBinary
    {
        private readonly IExpression left;
        private readonly IExpression right;

        public Divide(IExpression left, IExpression right, PositionInText position)
            : base(position)
        {
            this.left = left;
            this.right = right;
        }

        public IExpression Left()
        { return left; }

        public IExpression Right()
        { return right; }

        public void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }
        public T Accept<T>(Visitors.IVisitor<T> visitor) 
        {
           return visitor.Visit(this);
        }

        public string MakeString()
        {
            return "+";
        }
    }
}
