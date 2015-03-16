using AST.Nodes;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.ASTVisitors.Interfaces;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecker.Collectors
{
    public class TopLevelExpressionCollector : FormObjectVisitor<IList<BaseExpression>>, FormVisitor<IList<BaseExpression>>
    {
        //selectmany flattens lists of lists.
        public override IList<BaseExpression> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<BaseExpression> Visit(Conditional node)
        {
            List<BaseExpression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public override IList<BaseExpression> Visit(Question node)
        {
            List<BaseExpression> idList = new List<BaseExpression>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           return idList;
        }
    }
}
