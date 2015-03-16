using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.Nodes.FormObject;
using AST.ASTVisitors;
using System.Collections.Generic;
using System.Linq;


namespace TypeChecker.Collectors
{
    public class UsedIdentifierCollector : BaseVisitor<IList<Id>>
    {
        //selectmany flattens lists of lists.
        public override IList<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Id> Visit(Conditional node)
        {
            return node.Condition.Accept(this) //Gather the Ientifiers from the condition
                   .Concat(
                        node.GetBody() //Gather the Identifiers from the body
                       .SelectMany(x => x.Accept(this))
                   )
                   .ToList();
        }
        public override IList<Id> Visit(Question node)
        {
            List<Id> idList = new List<Id>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           idList.Add(node.Identifier);
           return idList;
        }

        //Expression
        public override IList<Id> Visit(Binary node)
        {
            return node.Left()
                       .Accept(this)
                       .Concat(
                           node.Right()
                               .Accept(this)
                      ).ToList();
        }

        public override IList<Id> Visit(Id node)
        {
            return new List<Id> { node };
        }

        public override IList<Id> Visit(And node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Or node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(GreaterThan node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(GreaterThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(LessThan node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(LessThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Add node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Subtract node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Multiply node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Divide node)
        {
            return VisitBinary(node);
        }

        public override IList<Id> Visit(Negate node)
        {
            return VisitUnary(node);
        }

        public override IList<Id> Visit(Priority node)
        {
            return VisitUnary(node);
        }

        private IList<Id> VisitBinary(Binary node)
        {
            return node.Left()
                         .Accept(this)
                         .Concat(
                             node.Right()
                                 .Accept(this)
                        ).ToList();
        }

        private IList<Id> VisitUnary(Unary node)
        {
            return node.GetChildExpression().Accept(this);
        }
    }
}
