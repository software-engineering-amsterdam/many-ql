using AST.Nodes.Interfaces;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Expression.Unary;
using AST.Nodes.Expression;
using AST.Nodes.Values;
namespace AST.Evaluation
{
    public class ExpressionVisitor : BaseVisitor<Value>
    {
         IDictionary<string, IValue> identifierLookup;

        public ExpressionVisitor(IDictionary<string, IValue> identifierLookup)
        {
            this.identifierLookup = identifierLookup;
        }

        public override Value Visit(And node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolAnd((dynamic)right);
        }
        public override Value Visit(Or node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolOr((dynamic)right);

        }
        public override Value Visit(Equal node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolEqual((dynamic)right);
        }

        public override Value Visit(NotEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolNotEqual((dynamic)right);
        }
        public override Value Visit(Negate node)
        {

            Value value = node.Accept(this);
            return value.Negate();
        }
        public override Value Visit(Container node) {
            throw new NotImplementedException();
        }
    }
}
