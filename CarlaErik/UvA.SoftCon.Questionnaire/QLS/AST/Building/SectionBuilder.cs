using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class SectionBuilder : QLSBaseVisitor<Section>
    {
        public override Section VisitSection(QLSParser.SectionContext context)
        {
            string title = context.STRING().GetText();
            var questionStyles = new List<QuestionReference>();
            var defaultStyles = new List<DefaultStyle>();

            // Remove the leading and trailing '"' characters from the string literal.
            title = title.Trim('"');

            foreach (var questionStyleContext in context.question_ref())
            {
                questionStyles.Add(questionStyleContext.Accept(new QuestionReferenceBuilder()));
            }
            foreach (var defaultStyleContext in context.default_styles())
            {
                defaultStyles.Add(defaultStyleContext.Accept(new DefaultStyleBuilder()));
            }

            return new Section(title, questionStyles, defaultStyles, context.GetTextPosition());
        }
    }
}
