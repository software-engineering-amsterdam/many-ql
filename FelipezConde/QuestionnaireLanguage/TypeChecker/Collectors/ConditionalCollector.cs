using AST.Nodes;
using AST.Nodes.FormObject;
using AST.ASTVisitors;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecker.Collectors
{
    public class ConditionalCollector : BaseVisitor<IList<Conditional>>
    {
        //selectmany flattens lists of lists.

        public override IList<Conditional> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Conditional> Visit(Conditional node)
        {
            var acc = node.GetBody()
                          .SelectMany(x => x.Accept(this))
                          .ToList();

            acc.Add(node);
            return acc;

        }

        public override IList<Conditional> Visit(Question node)
        {
            return new List<Conditional>();
        }

 
    }
}
