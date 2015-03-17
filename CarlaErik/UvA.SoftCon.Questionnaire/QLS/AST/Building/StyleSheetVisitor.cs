using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class StyleSheetVisitor : QLSBaseVisitor<StyleSheet>
    {
        public override StyleSheet VisitStyleSheet(QLSParser.StyleSheetContext context)
        {
            var id = new Identifier(context.ID().GetText(), context.GetTextPosition());
            var pages = new List<Page>();

            foreach (var child in context.page())
            {
                pages.Add(child.Accept(new PageVisitor()));
            }

            return new StyleSheet(id, pages, context.GetTextPosition());
        }
    }
}
