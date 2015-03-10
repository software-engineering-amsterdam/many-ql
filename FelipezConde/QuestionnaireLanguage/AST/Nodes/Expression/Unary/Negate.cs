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

        public Types.Type GetCompatibleType(Types.BoolType ChildType)
        {
            return new Types.BoolType();
        }

        public Types.Type GetCompatibleType(Types.Type rightType)
        {
            return new Types.UndefinedType();
        }
    }
}


