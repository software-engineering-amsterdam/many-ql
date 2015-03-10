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
    public class UsedIdentifierCollector : BaseVisitor<IList<Id>>
    {
        //selectmany flattens lists of lists.
        public override IList<Id> Visit(Nodes.Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Id> Visit(Nodes.FormObject.Conditional node)
        {
            return node.Condition.Accept(this) //Gather the Ientifiers from the condition
                   .Concat(
                        node.GetBody() //Gather the Identifiers from the body
                       .SelectMany(x => x.Accept(this))
                   )
                   .ToList();
        }
        public override IList<Id> Visit(Nodes.FormObject.Question node)
        {
            List<Id> idList = new List<Id>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           idList.Add(new Id(node.Identifier, node.GetPosition()));
           return idList;
        }

        //Expression
        public override IList<Id> Visit(IBinary node) //Is this a hack?
        {
            return node.Left()
                       .Accept(this)
                       .Concat(
                           node.Right()
                               .Accept(this)
                      ).ToList();
        }

        public override IList<Id> Visit(IUnary node) //Is this a hack?
        {
            return node.GetChildExpression().Accept(this);
        }

        public override IList<Id> Visit(Container node)
        {
            return new List<Id>();
        }

        public override IList<Id> Visit(Id node)
        {
            return new List<Id> { node };
        }
        

    }
}
