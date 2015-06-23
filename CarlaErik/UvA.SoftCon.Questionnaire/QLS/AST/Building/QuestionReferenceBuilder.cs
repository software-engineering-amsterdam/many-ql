using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class QuestionReferenceBuilder : QLSBaseVisitor<QuestionReference>
    {
        public override QuestionReference VisitQuestionReference(QLSParser.QuestionReferenceContext context)
        {
            Identifier id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            var styleAttributes = new List<StyleAttribute>();

            foreach (var styleAttributeContext in context.style_attr())
            {
                styleAttributes.Add(styleAttributeContext.Accept(new StyleAttributeBuilder()));
            }

            return new QuestionReference(id, styleAttributes, context.GetTextPosition());
        }
    }
}
