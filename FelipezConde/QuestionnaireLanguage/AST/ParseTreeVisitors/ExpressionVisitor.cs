using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Interfaces;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.Representation;
using Grammar;


namespace AST.ParseTreeVisitors
{
    public class ExpressionVisitor : QLMainBaseVisitor<BaseExpression>
    {
        public override BaseExpression VisitExpressionId(QLMainParser.ExpressionIdContext context)
        {
            return context.id().Accept(this);
        }

        public override BaseExpression VisitExpressionValue(QLMainParser.ExpressionValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        #region Associative
        public override BaseExpression VisitAssociativeValue(QLMainParser.AssociativeValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        public override BaseExpression VisitAssociativeId(QLMainParser.AssociativeIdContext context)
        {
            return context.id().Accept(this);
        }

        public override BaseExpression VisitId(QLMainParser.IdContext context)
        {
            string id = context.ALPHANUMERIC().GetText();
            return new Id(id, new PositionInText(context));
        }

        public override BaseExpression VisitAND(QLMainParser.ANDContext context)
        {
            return new And(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }

        public override BaseExpression VisitOR(QLMainParser.ORContext context)
        {
            return new Or(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),

                    new PositionInText(context)
                );
        }

        public override BaseExpression VisitDIV(QLMainParser.DIVContext context)
        {
            return new Divide(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }


        public override BaseExpression VisitMUL(QLMainParser.MULContext context)
        {
            return new Multiply(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }
        public override BaseExpression VisitSUB(QLMainParser.SUBContext context)
        {
            return new Subtract(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    new PositionInText(context)
                );
        }

        public override BaseExpression VisitADD(QLMainParser.ADDContext context)
        {
            return new Add(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }
        #endregion

        #region Non-Associative
        public override BaseExpression VisitEQ(QLMainParser.EQContext context)
        {
            return new Equal(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }
        public override BaseExpression VisitNEQ(QLMainParser.NEQContext context)
        {
            return new NotEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override BaseExpression VisitGT(QLMainParser.GTContext context)
        {
            return new GreaterThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override BaseExpression VisitGET(QLMainParser.GETContext context)
        {
            return new GreaterThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override BaseExpression VisitLT(QLMainParser.LTContext context)
        {
            return new LessThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override BaseExpression VisitLET(QLMainParser.LETContext context)
        {
            return new LessThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                new PositionInText(context)
            );
        }

        public override BaseExpression VisitNonAssociativePriority(QLMainParser.NonAssociativePriorityContext context)
        {
            return context.expression().Accept(this);
        }

        public override BaseExpression VisitNonAssociativeValue(QLMainParser.NonAssociativeValueContext context)
        {
            return context.value().Accept(new LiteralVisitor());
        }

        public override BaseExpression VisitNonAssociativeId(QLMainParser.NonAssociativeIdContext context)
        {
            return context.id().Accept(this);
        }

        public override BaseExpression VisitAssociativeUnary(QLMainParser.AssociativeUnaryContext context)
        {
            return context.unary().Accept(new UnaryVisitor());
        }
        #endregion
    }
}
