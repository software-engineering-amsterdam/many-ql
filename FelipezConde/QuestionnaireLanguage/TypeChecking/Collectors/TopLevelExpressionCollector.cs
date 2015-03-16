using AST.Nodes;
using AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using AST.ASTVisitors.Interfaces;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecking.Collectors
{
    public class TopLevelExpressionCollector : IFormObjectVisitor<IList<BaseExpression>>, IFormVisitor<IList<BaseExpression>>
    {
        //selectmany flattens lists of lists.
        public IList<BaseExpression> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public IList<BaseExpression> Visit(Conditional node)
        {
            List<BaseExpression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public IList<BaseExpression> Visit(Question node)
        {
            List<BaseExpression> expressionList = new List<BaseExpression>();

            if (node.Computation != null)
                expressionList.Add(node.Computation);

           return expressionList;
        }
    }
}
