using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecking.Collectors
{
    public class IdentifierTypeCollector : IFormVisitor<IEnumerable<Id>>, IFormObjectVisitor<IEnumerable<Id>>
    {
        public IEnumerable<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public IEnumerable<Id> Visit(Question node)
        {
            Id identifier = node.Identifier;
            identifier.SetType(node.RetrieveType());

            return new List<Id> { node.Identifier };
        }

        public IEnumerable<Id> Visit(Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

    }
}
