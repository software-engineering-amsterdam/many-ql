using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ParseTreeVisitors
{
    public class UnaryVisitor : QLMainBaseVisitor<IExpression>
    {
        public override IExpression VisitNegateUnary(QLMainParser.NegateUnaryContext context)
        {
            return context.expression().Accept(new UnaryVisitor());
        }

        public override IExpression VisitPriorityUnary(QLMainParser.PriorityUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
    }
}
