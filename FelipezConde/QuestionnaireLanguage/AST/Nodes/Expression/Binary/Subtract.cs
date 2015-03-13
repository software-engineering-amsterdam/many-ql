using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Representation;

namespace AST.Nodes.Expression.Binary
{
    public class Subtract : ASTNode, IExpression, IBinary
    {
        private readonly IExpression left;
        private readonly IExpression right;

        public Subtract(IExpression left, IExpression right, PositionInText position)
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
            return "-";
        }

        public Types.Type GetCompatibleType(Literals.Int leftType, Types.IntType rightType)
        {
            return new Types.IntType();
        }

        public Types.Type GetCompatibleType(Types.Type leftType, Types.Type rightType)
        {
            return new Types.UndefinedType();
        }
    }
}
