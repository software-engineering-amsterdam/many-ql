using AST.Nodes;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecking.Collectors
{
    public class ConditionalCollector : IFormVisitor<IList<Conditional>>, IFormObjectVisitor<IList<Conditional>>
    {
        //selectmany flattens lists of lists.

        public IList<Conditional> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public IList<Conditional> Visit(Conditional node)
        {
            var acc = node.GetBody()
                          .SelectMany(x => x.Accept(this))
                          .ToList();

            acc.Add(node);
            return acc;

        }

        public IList<Conditional> Visit(Question node)
        {
            return new List<Conditional>();
        }

 
    }
}
