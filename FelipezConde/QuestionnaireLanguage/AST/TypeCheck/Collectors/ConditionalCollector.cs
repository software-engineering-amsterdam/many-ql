using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.TypeCheck.Collectors
{
    public class ConditionalCollector : BaseVisitor<IList<Conditional>>
    {
        //selectmany flattens lists of lists.

        public override IList<Conditional> Visit(Nodes.Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Conditional> Visit(Nodes.FormObject.Conditional node)
        {
            var acc = node.GetBody()
                          .SelectMany(x => x.Accept(this))
                          .ToList();

            acc.Add(node);
            return acc;

        }

        public override IList<Conditional> Visit(Nodes.FormObject.Question node)
        {
            return new List<Conditional>();
        }

 
    }
}
