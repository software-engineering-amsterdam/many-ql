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
            List<IExpression> expressionsInBody = node.Body.SelectMany(x => x.Accept(this)).ToList();
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

        //Computed Question
        public override IList<IExpression> Visit(Nodes.Computation.Expression node)
        { 
            return new List<IExpression>{node.ExpressionValue}; 
        }
        public override IList<IExpression> Visit(Nodes.Computation.Id node)
        { 
            return new List<IExpression>{
                new Nodes.Expression.Id(node.Value, node.GetPosition())
            }; 
        }
        public override IList<IExpression> Visit(Nodes.Computation.Value node)
        { 
            return new List<IExpression> { 
                new Nodes.Expression.Container(node.GetParsedString(), node.ElementValue, node.GetPosition())
            }; 
        }
    }
}
