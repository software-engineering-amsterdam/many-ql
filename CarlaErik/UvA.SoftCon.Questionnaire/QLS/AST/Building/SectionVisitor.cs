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
    internal class SectionVisitor : QLSBaseVisitor<Section>
    {
        public override Section VisitSection(QLSParser.SectionContext context)
        {
            var questionStyles = new List<QuestionStyle>();
            var defaultStyles = new List<DefaultStyle>();

            foreach (var questionStyleContext in context.question_styles())
            {
                questionStyles.Add(questionStyleContext.Accept(new QuestionStyleVisitor()));
            }
            foreach (var defaultStyleContext in context.default_styles())
            {
                defaultStyles.Add(defaultStyleContext.Accept(new DefaultStyleVisitor()));
            }

            return new Section(questionStyles, defaultStyles, context.GetTextPosition());
        }
    }
}
