using AST.Nodes;
using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using AST.Nodes.FormObjects;
using AST.VisitorInterfaces;
using System.Collections.Generic;
using System.Linq;
using AST.Nodes.Literals;


namespace TypeChecking.Collectors
{
    public class UsedIdentifierCollector : IFormVisitor<IEnumerable<Id>>, IFormObjectVisitor<IEnumerable<Id>>, IExpressionVisitor<IEnumerable<Id>>
    {
        //selectmany flattens lists of lists.
        public  IEnumerable<Id> Visit(Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this));
        }

        public  IEnumerable<Id> Visit(Conditional node)
        {
            return node.Condition.Accept(this) //Gather the Ientifiers from the condition
                   .Concat(
                        node.GetBody() //Gather the Identifiers from the body
                       .SelectMany(x => x.Accept(this))
                   );
        }
        public  IEnumerable<Id> Visit(Question node)
        {
            List<Id> idList = new List<Id>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           idList.Add(node.Identifier);
           return idList;
        }

        //Expression
        public  IEnumerable<Id> Visit(Binary node)
        {
            return node.Left()
                       .Accept(this)
                       .Concat(
                           node.Right()
                               .Accept(this)
                      );
        }

        public  IEnumerable<Id> Visit(Id node)
        {
            return new List<Id> { node };
        }

        public  IEnumerable<Id> Visit(And node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Or node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Equal node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(NotEqual node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(GreaterThan node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(GreaterThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(LessThan node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(LessThanOrEqual node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Add node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Subtract node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Multiply node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Divide node)
        {
            return VisitBinary(node);
        }

        public  IEnumerable<Id> Visit(Negate node)
        {
            return VisitUnary(node);
        }

        public  IEnumerable<Id> Visit(Priority node)
        {
            return VisitUnary(node);
        }

        private IEnumerable<Id> VisitBinary(Binary node)
        {
            return node.Left()
                         .Accept(this)
                         .Concat(
                             node.Right()
                                 .Accept(this)
                        );
        }

        private IEnumerable<Id> VisitUnary(Unary node)
        {
            return node.GetChildExpression().Accept(this);
        }

        public IEnumerable<Id> visit(Id node)
        {
            return new List<Id>();
        }

        public IEnumerable<Id> Visit(Bool node)
        {
            return new List<Id>();
        }

        public IEnumerable<Id> Visit(Int node)
        {
            return new List<Id>();
        }

        public IEnumerable<Id> Visit(AST.Nodes.Literals.String node)
        {
            return new List<Id>();
        }
    }
}
