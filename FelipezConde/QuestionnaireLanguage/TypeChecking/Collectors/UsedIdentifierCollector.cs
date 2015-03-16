using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.Nodes.FormObjects;
using AST.ASTVisitors.Interfaces;
using System.Collections.Generic;
using System.Linq;
using AST.Nodes.Literals;


namespace TypeChecking.Collectors
{
    public class UsedIdentifierCollector : IFormVisitor<IList<Id>>, IFormObjectVisitor<IList<Id>>, IExpressionVisitor<IList<Id>>
    {
        //selectmany flattens lists of lists.
        public  IList<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public  IList<Id> Visit(Conditional node)
        {
            return node.Condition.Accept(this) //Gather the Ientifiers from the condition
                   .Concat(
                        node.GetBody() //Gather the Identifiers from the body
                       .SelectMany(x => x.Accept(this))
                   )
                   .ToList();
        }
        public  IList<Id> Visit(Question node)
        {
            List<Id> idList = new List<Id>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           idList.Add(node.Identifier);
           return idList;
        }

        //Expression
        public  IList<Id> Visit(BaseBinary node)
        {
            return node.Left()
                       .Accept(this)
                       .Concat(
                           node.Right()
                               .Accept(this)
                      ).ToList();
        }

        public  IList<Id> Visit(Id node)
        {
            return new List<Id> { node };
        }

        public  IList<Id> Visit(And node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Or node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(GreaterThan node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(GreaterThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(LessThan node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(LessThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Add node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Subtract node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Multiply node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Divide node)
        {
            return VisitBinary(node);
        }

        public  IList<Id> Visit(Negate node)
        {
            return VisitUnary(node);
        }

        public  IList<Id> Visit(Priority node)
        {
            return VisitUnary(node);
        }

        private IList<Id> VisitBinary(BaseBinary node)
        {
            return node.Left()
                         .Accept(this)
                         .Concat(
                             node.Right()
                                 .Accept(this)
                        ).ToList();
        }

        private IList<Id> VisitUnary(BaseUnary node)
        {
            return node.GetChildExpression().Accept(this);
        }

        public IList<Id> visit(Id node)
        {
            return new List<Id>(); ;
        }

        public IList<Id> Visit(Bool node)
        {
            return new List<Id>();
        }

        public IList<Id> Visit(Int node)
        {
            return new List<Id>();
        }

        public IList<Id> Visit(AST.Nodes.Literals.String node)
        {
            return new List<Id>();
        }
    }
}
