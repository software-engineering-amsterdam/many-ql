using AST.Helpers;
using AST.Nodes.Expression;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Interfaces;
using AST.Representation;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AST.ParseTreeVisitors
{
    public class ExpressionVisitor : QLMainBaseVisitor<IExpression>
    {

        /*    Associative     */
        #region Associative
        public override IExpression VisitAssociativeValue(QLMainParser.AssociativeValueContext context)
        {
            return context.value().Accept(new ValueVisitor());
        }

        public override IExpression VisitAssociativeId(QLMainParser.AssociativeIdContext context)
        {
            return context.id().Accept(this);
        }

        public override IExpression VisitId(QLMainParser.IdContext context)
        {
            string id = context.ALPHANUMERIC().GetText();
            return new Id(id, Position.PositionFormParserRuleContext(context));
        }

        public override IExpression VisitAND(QLMainParser.ANDContext context)
        {
            return new And(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    Position.PositionFormParserRuleContext(context)
                );
        }

        public override IExpression VisitOR(QLMainParser.ORContext context)
        {
            return new Or(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    context.GetText(),
                    Position.PositionFormParserRuleContext(context)
                );
        }

        public override IExpression VisitDIV(QLMainParser.DIVContext context)
        {
            return new Divide(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    context.GetText(),
                    Position.PositionFormParserRuleContext(context)
                );
        }


        public override IExpression VisitMUL(QLMainParser.MULContext context)
        {
            return new Multiply(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    context.GetText(),
                    Position.PositionFormParserRuleContext(context)
                );
        }
        public override IExpression VisitSUB(QLMainParser.SUBContext context)
        {
            return new Subtract(
                    context.associative(0).Accept(this),
                    context.associative(1).Accept(this),
                    context.GetText(),
                    Position.PositionFormParserRuleContext(context)
                );
        }

        public override IExpression VisitADD(QLMainParser.ADDContext context)
        {
            return new Add(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                context.GetText(),
                Position.PositionFormParserRuleContext(context)
            );
        }
        #endregion
        /*    Non-associative     */
        #region Non-Associative
        public override IExpression VisitEQ(QLMainParser.EQContext context)
        {
            return new Equal(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                Position.PositionFormParserRuleContext(context)
            );
        }
        public override IExpression VisitNEQ(QLMainParser.NEQContext context)
        {
            return new NotEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                context.GetText(),
                Position.PositionFormParserRuleContext(context)
            );
        }

        public override IExpression VisitGT(QLMainParser.GTContext context)
        {
            return new GreaterThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                Position.PositionFormParserRuleContext(context)
            );
        }

        public override IExpression VisitGET(QLMainParser.GETContext context)
        {
            return new GreaterThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                Position.PositionFormParserRuleContext(context)
            );
        }

        public override IExpression VisitLT(QLMainParser.LTContext context)
        {
            return new LessThan(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                Position.PositionFormParserRuleContext(context)
            );
        }

        public override IExpression VisitLET(QLMainParser.LETContext context)
        {
            return new LessThanOrEqual(
                context.associative(0).Accept(this),
                context.associative(1).Accept(this),
                Position.PositionFormParserRuleContext(context)
            );
        }

        public override IExpression VisitNonAssociativePriority(QLMainParser.NonAssociativePriorityContext context)
        {
            return context.expression().Accept(new ValueVisitor());
        }

        public override IExpression VisitNonAssociativeValue(QLMainParser.NonAssociativeValueContext context)
        {
            return context.value().Accept(new ValueVisitor());
        }

        public override IExpression VisitNonAssociativeId(QLMainParser.NonAssociativeIdContext context)
        {
            return context.id().Accept(new ValueVisitor());
        }

        public override IExpression VisitAssociativeUnary(QLMainParser.AssociativeUnaryContext context)
        {
            return context.unary().Accept(new UnaryVisitor());
        }
        #endregion
    }
}
