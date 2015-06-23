using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class PageBuilder : QLSBaseVisitor<Page>
    {
        public override Page VisitPage(QLSParser.PageContext context)
        {
            var id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            var sections = new List<Section>();
            var defaultStyles = new List<DefaultStyle>();

            foreach (var sectionContext in context.section())
            {
                sections.Add(sectionContext.Accept(new SectionBuilder()));
            }
            foreach (var defaultStyleContext in context.default_style())
            {
                defaultStyles.Add(defaultStyleContext.Accept(new DefaultStyleBuilder()));
            }

            return new Page(id, sections, defaultStyles, context.GetTextPosition());
        }
    }
}
