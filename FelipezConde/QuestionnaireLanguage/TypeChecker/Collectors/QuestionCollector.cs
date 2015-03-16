using AST.Nodes;
using AST.Nodes.FormObject;
using AST.ASTVisitors;
using System.Collections.Generic;
using System.Linq;

namespace TypeChecker.Collectors
{
    public class QuestionCollector : BaseVisitor<IList<Question>>
    {
        //selectmany flattens lists of lists.

        public override IList<Question> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Question> Visit(Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public override IList<Question> Visit(Question node)
        {
            return new List<Question> { node };
        }

 
    }
}
