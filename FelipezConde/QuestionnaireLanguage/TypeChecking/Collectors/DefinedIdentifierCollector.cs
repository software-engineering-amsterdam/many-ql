using AST.Nodes.Expressions;
using AST.VisitorInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TypeChecking.Collectors
{
    public class DefinedIdentifierCollector : IFormObjectVisitor<IEnumerable<Id>>
    {
        public IEnumerable<Id> Visit(AST.Nodes.FormObjects.Conditional conditional)
        {
            return conditional.GetBody().SelectMany(x => x.Accept(this));
        }

        public IEnumerable<Id> Visit(AST.Nodes.FormObjects.Question question)
        {
            return new List<Id> { question.Identifier };
        }
    }
}
