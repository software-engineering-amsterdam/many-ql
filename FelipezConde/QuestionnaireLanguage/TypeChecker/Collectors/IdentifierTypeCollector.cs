using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObject;
using AST.ASTVisitors;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecker.Collectors
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
