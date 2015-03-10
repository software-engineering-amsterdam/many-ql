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
    public class QuestionCollector : BaseVisitor<IList<Question>>
    {
        //selectmany flattens lists of lists.

        public override IList<Question> Visit(Nodes.Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Question> Visit(Nodes.FormObject.Conditional node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }
        public override IList<Question> Visit(Nodes.FormObject.Question node)
        {
            return new List<Question> { node };
        }

 
    }
}
