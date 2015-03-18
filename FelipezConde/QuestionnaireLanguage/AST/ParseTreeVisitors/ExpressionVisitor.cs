using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using Grammar;


namespace AST.ParseTreeVisitors
{
    public class ExpressionVisitor : QLMainBaseVisitor<Expression>
    {
        public override Expression VisitExpressionId(QLMainParser.ExpressionIdContext context)
        {
            return context.id().Accept(this);
        }

        public override Expression VisitExpressionValue(QLMainParser.ExpressionValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        #region Associative
        public override Expression VisitAssociativeValue(QLMainParser.AssociativeValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        public override Expression VisitAssociativeId(QLMainParser.AssociativeIdContext context)
        {
            return context.id().Accept(this);
        }

        public override Expression VisitId(QLMainParser.IdContext context)
        {
            string id = context.ALPHANUMERIC().GetText();
            return new Id(id, new PositionInText(context));
        }

        public override Expression VisitAND(QLMainParser.ANDContext context)
        {
            return new And(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }

        public override Expression VisitOR(QLMainParser.ORContext context)
        {
            return new Or(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),

                    new PositionInText(context)
                );
        }

        public override Expression VisitDIV(QLMainParser.DIVContext context)
        {
            return new Divide(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }


        public override Expression VisitMUL(QLMainParser.MULContext context)
        {
            return new Multiply(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }
        public override Expression VisitSUB(QLMainParser.SUBContext context)
        {
            return new Subtract(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }

        public override Expression VisitADD(QLMainParser.ADDContext context)
        {
            return new Add(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }
        #endregion

        #region Non-Associative
        public override Expression VisitEQ(QLMainParser.EQContext context)
        {
            return new Equal(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }
        public override Expression VisitNEQ(QLMainParser.NEQContext context)
        {
            return new NotEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override Expression VisitGT(QLMainParser.GTContext context)
        {
            return new GreaterThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override Expression VisitGET(QLMainParser.GETContext context)
        {
            return new GreaterThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override Expression VisitLT(QLMainParser.LTContext context)
        {
            return new LessThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override Expression VisitLET(QLMainParser.LETContext context)
        {
            return new LessThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override Expression VisitNonAssociativePriority(QLMainParser.NonAssociativePriorityContext context)
        {
            return context.expression().Accept(this);
        }

        public override Expression VisitNonAssociativeValue(QLMainParser.NonAssociativeValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        public override Expression VisitNonAssociativeId(QLMainParser.NonAssociativeIdContext context)
        {
            return context.id().Accept(this);
        }

        public override Expression VisitAssociativeUnary(QLMainParser.AssociativeUnaryContext context)
        {
            return context.unary().Accept(new UnaryVisitor());
        }
        #endregion
    }
}
