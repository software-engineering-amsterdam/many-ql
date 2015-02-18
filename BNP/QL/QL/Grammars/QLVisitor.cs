using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Grammars
{
    public class QLVisitor : QLBaseVisitor<QLParser.FormBlockContext>
    {
        public QLVisitor()
        {
            
        }

        public override QLParser.FormBlockContext Visit(Antlr4.Runtime.Tree.IParseTree tree)
        {
            return base.Visit(tree);
        }
    }
}
