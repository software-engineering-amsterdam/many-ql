using AST.Nodes;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.Visitors;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecker.Collectors
{
    public class TopLevelExpressionCollector : BaseVisitor<IList<IExpression>>
    {
        //selectmany flattens lists of lists.
        public override IList<IExpression> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<IExpression> Visit(Conditional node)
        {
            List<IExpression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public override IList<IExpression> Visit(Question node)
        {
            List<IExpression> idList = new List<IExpression>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           return idList;
        }
    }
}
