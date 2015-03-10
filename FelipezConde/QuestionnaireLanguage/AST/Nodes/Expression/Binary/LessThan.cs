using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Representation;

namespace AST.Nodes.Expression.Binary
{
    public class LessThan : ASTNode, IExpression, IBinary
    {
        private readonly IExpression left;
        private readonly IExpression right;

        public LessThan(IExpression left, IExpression right, Representation.PositionInText position)
            : base(position)
        {
            this.left = left;
            this.right = right;
        }
        public IExpression Left()
        { return left; }

        public IExpression Right()
        { return right; }

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

        public string MakeString()
        {
            return "<";
        }

        public IValue GetCompatibleType(Values.Int leftType, Values.Int rightType)
        {
            return new Values.Bool(true);
        }

        public IValue GetCompatibleType(IValue leftType, IValue rightType)
        {
            return new Values.Undefined();
        }


    }

}
