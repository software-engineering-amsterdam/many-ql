using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.FormObject;
using AST.Representation;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.TypeCheck.Collectors
{
    public class IdentifierTypeCollector : BaseVisitor<IList<Id>>
    {
        public override IList<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public override IList<Id> Visit(Question node)
        {
            Id identifier = node.Identifier;
            identifier.SetType(node.RetrieveType());

            return new List<Id> { node.Identifier };
        }

        public override IList<Id> Visit(Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

    }
}
