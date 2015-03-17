using AST.Nodes;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecking.Collectors
{
    public class QuestionCollector : IFormVisitor<IList<Question>>, IFormObjectVisitor<IList<Question>>
    {
        //selectmany flattens lists of lists.

        public IList<Question> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public IList<Question> Visit(Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public IList<Question> Visit(Question node)
        {
            return new List<Question> { node };
        }

 
    }
}
