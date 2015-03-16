using AST.Nodes;
using AST.Nodes.Interfaces;
using Grammar;

namespace AST.ParseTreeVisitors
{
    public class UnaryVisitor : QLMainBaseVisitor<BaseExpression>
    {
        public override BaseExpression VisitNegateUnary(QLMainParser.NegateUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
        public override BaseExpression VisitPriorityUnary(QLMainParser.PriorityUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
    }
}
