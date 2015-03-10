using AST.Helpers;
using AST.Nodes.Interfaces;
using AST.Nodes.Labels;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ParseTreeVisitors
{
    public class LabelVisitor : QLMainBaseVisitor<ILabel>
    {
        public override ILabel VisitLabel(QLMainParser.LabelContext context)
        {
            string show = context.STRINGLITERAL().GetText();
            return new Label(show, show.Substring(1,show.Length - 2),
                                    Position.PositionFormParserRuleContext(context));
        }
    }
}
