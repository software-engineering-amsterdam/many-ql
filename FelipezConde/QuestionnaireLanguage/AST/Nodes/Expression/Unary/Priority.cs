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
        string parsedString;
        public Priority(IExpression child, string parsedString, PositionInText position)
            : base(position)
        {
            this.expression = child;
            this.parsedString = parsedString;
        }

        public override string GetParsedString()
        { return parsedString; }

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

        //TypeCheck

        public Types.Type GetCompatibleType(Types.BoolType ChildType)
        {
            return new Types.BoolType();
        }

        public Types.Type GetCompatibleType(Types.IntType ChildType)
        {
            return new Types.IntType();
        }

        public Types.Type GetCompatibleType(Types.Type rightType)
        {
            return new Types.UndefinedType();
        }

    }
}
