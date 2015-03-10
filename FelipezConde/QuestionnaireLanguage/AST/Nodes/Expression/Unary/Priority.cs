using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        { return visitor.Visit(this); }

        public override void Accept(Visitors.IVisitor visitor)
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

        public IValue GetCompatibleType(Values.Bool ChildType)
        {
            return new Values.Bool(true);
        }

        public IValue GetCompatibleType(Values.Int ChildType)
        {
            return new Values.Int(0);
        }

        public IValue GetCompatibleType(IValue rightType)
        {
            return new Values.Undefined();
        }

    }
}
