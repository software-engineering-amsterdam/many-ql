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

namespace AST.ParseTreeVisitors
{
    public class FormObjectVisitor : QLMainBaseVisitor<IFormObject>
    {
        public override IFormObject VisitQuestion(QLMainParser.QuestionContext context)
        {

            string identifier = context.id().GetText();
            Types.Type typeName = context.type().Accept(new TypeVisitor());

            ILabel label = context.label().Accept(new LabelVisitor());
            IExpression computation = context.computed() != null ? context.computed().expression().Accept(new ExpressionVisitor()) : null;

            return new Question(identifier, typeName, label, computation,
                                Position.PositionFormParserRuleContext(context));
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
