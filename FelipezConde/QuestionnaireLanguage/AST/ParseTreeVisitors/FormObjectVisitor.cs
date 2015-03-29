using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
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

            Expression computation = context.computed() != null ? context.computed().expression().Accept(new ExpressionVisitor()) : null;

            return new Question(new Id(identifier,IdPosition), typeName, MakeLabel(context.label()), computation,
                                position);
        }

        public override FormObject VisitConditional(QLMainParser.ConditionalContext context)
        {
            Expression condition = context.expression().Accept(new ExpressionVisitor());

            List<FormObject> body = context.formSection()
                                         .formObject()
                                         .Select(child => child.Accept(new FormObjectVisitor()))
                                         .ToList();

            return new Conditional(condition, body, new PositionInText(context));

        }

        private Label MakeLabel(QLMainParser.LabelContext context)
        {
            string labelText = context.STRINGLITERAL().GetText();
            return new Label(labelText.Substring(1, labelText.Length - 2), new PositionInText(context));
        }
    }
}
