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

           idList.Add(node.Identifier);
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
        public override IList<Id> Visit(Container node)
        {
            return new List<Id>();
        }

        public override IList<Id> Visit(Id node)
        {
            return new List<Id> { node };
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.And node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Or node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Equal node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.NotEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.GreaterThan node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.GreaterThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.LessThan node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.LessThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Add node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Subtract node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Multiply node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Binary.Divide node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Unary.Negate node)
        {
            return VisitUnary(node);
        }

        public override IList<Id> Visit(Nodes.Expression.Unary.Priority node)
        {
            return VisitUnary(node);
        }

        private IList<Id> VisitBinary(IBinary node)
        {
            return node.Left()
                         .Accept(this)
                         .Concat(
                             node.Right()
                                 .Accept(this)
                        ).ToList();
        }

        private IList<Id> VisitUnary(IUnary node)
        {
            return node.GetChildExpression().Accept(this);
        }
    }
}
