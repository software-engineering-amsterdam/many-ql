using AST.Nodes.Expression;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using AST.Representation;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AST.TypeCheck.Collectors
{
    public class TopLevelExpressionCollector : BaseVisitor<IList<IExpression>>
    {
        //selectmany flattens lists of lists.
        public override IList<IExpression> Visit(Nodes.Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<IExpression> Visit(Nodes.FormObject.Conditional node)
        {
            List<IExpression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public override IList<IExpression> Visit(Nodes.FormObject.Question node)
        {
            List<IExpression> idList = new List<IExpression>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           return idList;
        }
    }
}
