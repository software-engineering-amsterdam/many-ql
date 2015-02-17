using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Tree;
using QL.Grammars;
using QL.Model.Terminals;

namespace QL.Model
{
    public sealed class NodeMapper
    {
        public UnitBase Create(QLParser.UnitContext context)
        {
            var id = context.GetChild(1).GetText();
            var question = context.GetChild(context.ChildCount - 2).GetText();
            var arguments = context.children.Skip(3).Select(child => child.GetText()).Take(context.ChildCount - 3 - 3).ToArray();

            QuestionUnit questionUnit = new QuestionUnit(id, question, arguments);

            return questionUnit;
        }

        // todo: move to own mapper
        public ElementBase Create(QLParser.FormBlockContext context)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<ElementBase> ExtractChilds();
    }
}
