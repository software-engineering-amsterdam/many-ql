using AST.Helpers;
using AST.Nodes.Computation;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;

namespace AST.ParseTreeVisitors
{
    public class ComputationVisitor : QLMainBaseVisitor<IComputation>
    {
        public override IComputation VisitComputationId(QLMainParser.ComputationIdContext context)
        {
            string id = context.id().GetText();
            return new Id(id, id,
                                    Position.PositionFormParserRuleContext(context));
        }

        public override IComputation VisitComputationValue(QLMainParser.ComputationValueContext context)
        {
            IValue value = context.value().Accept(new ValueVisitor());
            return new Value(context.value().GetText(), value,
                                    Position.PositionFormParserRuleContext(context));
        }

        public override IComputation VisitComputationExpression(QLMainParser.ComputationExpressionContext context)
        {
            IExpression expression = context.expression().Accept(new ExpressionVisitor());
            return new Expression(context.expression().GetText(), expression,
                                    Position.PositionFormParserRuleContext(context));
        }
    }
}
