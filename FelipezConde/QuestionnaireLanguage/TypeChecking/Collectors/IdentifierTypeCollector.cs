using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecking.Collectors
{
    public class IdentifierTypeCollector : IFormVisitor<IList<Id>>, IFormObjectVisitor<IList<Id>>
    {
        public IList<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public IList<Id> Visit(Question node)
        {
            Id identifier = node.Identifier;
            identifier.SetType(node.RetrieveType());

            return new List<Id> { node.Identifier };
        }

        public IList<Id> Visit(Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

    }
}
