using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;
using Grammar;

namespace AST.ParseTreeVisitors
{
    public class UnaryVisitor : QLMainBaseVisitor<Expression>
    {
        public override Expression VisitNegateUnary(QLMainParser.NegateUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
        public override Expression VisitPriorityUnary(QLMainParser.PriorityUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
    }
}
