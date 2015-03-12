using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using AST.Representation;
using AST.Helpers;
using Type = AST.Types;
using AST.Nodes.Expression;

namespace AST.ParseTreeVisitors
{
    public class FormObjectVisitor : QLMainBaseVisitor<IFormObject>
    {
        public override IFormObject VisitQuestion(QLMainParser.QuestionContext context)
        {
            string identifier = context.id().GetText();
            PositionInText IdPosition = Position.PositionFormParserRuleContext(context.id());
            PositionInText position = Position.PositionFormParserRuleContext(context);

            Types.Type typeName = context.type().Accept(new TypeVisitor());

            ILabel label = context.label().Accept(new LabelVisitor());
            IExpression computation = context.computed() != null ? context.computed().expression().Accept(new ExpressionVisitor()) : null;

            return new Question(new Id(identifier,IdPosition), typeName, label, computation,
                                position);
        }

        public override IFormObject VisitConditional(QLMainParser.ConditionalContext context)
        {
            IExpression condition = context.expression().Accept(new ExpressionVisitor());

            List<IFormObject> body = context.formSection()
                                         .formObject()
                                         .Select(child => child.Accept(new FormObjectVisitor()))
                                         .ToList();

            return new Conditional(condition, body, context.formSection().GetText(),
                                   Position.PositionFormParserRuleContext(context));

        }
    }
}
