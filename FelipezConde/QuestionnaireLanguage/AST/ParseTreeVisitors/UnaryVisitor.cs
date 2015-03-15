using AST.Nodes.Interfaces;
using Grammar;

namespace AST.ParseTreeVisitors
{
    public class UnaryVisitor : QLMainBaseVisitor<IExpression>
    {
        public override IExpression VisitNegateUnary(QLMainParser.NegateUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
        public override IExpression VisitPriorityUnary(QLMainParser.PriorityUnaryContext context)
        {
            return context.expression().Accept(new ExpressionVisitor());
        }
    }
}
