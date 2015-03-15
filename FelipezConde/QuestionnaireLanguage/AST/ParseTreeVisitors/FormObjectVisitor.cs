using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Nodes.Labels;
using AST.Representation;
using Grammar;
using System.Collections.Generic;
using System.Linq;

namespace AST.ParseTreeVisitors
{
    public class FormObjectVisitor : QLMainBaseVisitor<FormObject>
    {
        public override FormObject VisitQuestion(QLMainParser.QuestionContext context)
        {
            string identifier = context.id().GetText();
            PositionInText IdPosition = new PositionInText(context.id());
            PositionInText position = new PositionInText(context);

            Types.Type typeName = context.type().Accept(new TypeVisitor());

            QLMainParser.LabelContext labelContext = context.label();
            Label label = new Label(labelContext.STRINGLITERAL().GetText(), new PositionInText(labelContext));
            IExpression computation = context.computed() != null ? context.computed().expression().Accept(new ExpressionVisitor()) : null;

            return new Question(new Id(identifier,IdPosition), typeName, label, computation,
                                position);
        }

        public override FormObject VisitConditional(QLMainParser.ConditionalContext context)
        {
            IExpression condition = context.expression().Accept(new ExpressionVisitor());

            List<FormObject> body = context.formSection()
                                         .formObject()
                                         .Select(child => child.Accept(new FormObjectVisitor()))
                                         .ToList();

            return new Conditional(condition, body, new PositionInText(context));

        }
    }
}
