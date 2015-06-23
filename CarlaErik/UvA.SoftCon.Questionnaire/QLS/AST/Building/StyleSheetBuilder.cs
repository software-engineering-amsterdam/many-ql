using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    /// <summary>
    /// Builds a style sheet AST by visiting the <c>stylesheet</c> parser rule.
    /// </summary>
    internal class StyleSheetBuilder : QLSBaseVisitor<StyleSheet>
    {
        public override StyleSheet VisitStyleSheet(QLSParser.StyleSheetContext context)
        {
            var id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            var pages = new List<Page>();

            foreach (var child in context.page())
            {
                pages.Add(child.Accept(new PageBuilder()));
            }

            return new StyleSheet(id, pages, context.GetTextPosition());
        }
    }
}
