using AST.Nodes;
using AST.Nodes.FormObject;
using AST.Nodes.Interfaces;
using AST.ASTVisitors;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecker.Collectors
{
    public class TopLevelExpressionCollector : BaseVisitor<IList<Expression>>
    {
        //selectmany flattens lists of lists.
        public override IList<Expression> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Expression> Visit(Conditional node)
        {
            List<Expression> expressionsInBody = node.GetBody().SelectMany(x => x.Accept(this)).ToList();
                              expressionsInBody.Add(node.Condition);

            return expressionsInBody;
        }
        public override IList<Expression> Visit(Question node)
        {
            List<Expression> idList = new List<Expression>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           return idList;
        }
    }
}
