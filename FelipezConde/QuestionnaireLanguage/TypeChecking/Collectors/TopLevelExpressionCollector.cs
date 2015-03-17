using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.FormObjects;
using AST.Nodes.Interfaces;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecking.Collectors
{
    public class TopLevelExpressionCollector : IFormObjectVisitor<IList<Expression>>, IFormVisitor<IList<Expression>>
    {
        //selectmany flattens lists of lists.
        public IList<Expression> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public IList<Expression> Visit(Conditional node)
        {
            List<Expression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public IList<Expression> Visit(Question node)
        {
            List<Expression> expressionList = new List<Expression>();

            if (node.Computation != null)
                expressionList.Add(node.Computation);

           return expressionList;
        }
    }
}
