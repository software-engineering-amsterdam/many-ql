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
    public class UsedIdentifierCollector : BaseVisitor<IList<Identifier>>
    {
        //selectmany flattens lists of lists.
        public override IList<Identifier> Visit(Nodes.Form node)
        {
            return node.GetBody()
                       .SelectMany(x => x.Accept(this))
                       .ToList();
        }

        public override IList<Identifier> Visit(Nodes.FormObject.Conditional node)
        {
            return node.Condition.Accept(this) //Gather the Ientifiers from the condition
                   .Concat(
                        node.Body //Gather the Identifiers from the body
                       .SelectMany(x => x.Accept(this))
                   )
                   .ToList();
        }
        public override IList<Identifier> Visit(Nodes.FormObject.Question node)
        {
            List<Identifier> idList = new List<Identifier>();

            if (node.Computation != null)
                idList.AddRange(node.Computation.Accept(this));

           idList.Add(new Identifier(node, node.Identifier));
           return idList;
        }

        //Computed Question
        public override IList<Identifier> Visit(Nodes.Computation.Expression node)
        { return node.Accept(this); }
        public override IList<Identifier> Visit(Nodes.Computation.Id node)
        { 
            return new List<Identifier> { new Identifier(node, node.Value) }; 
        }
        public override IList<Identifier> Visit(Nodes.Computation.Value node)
        { return new List<Identifier>(); }

        //Expression
        public override IList<Identifier> Visit(IBinary node) //Is this a hack?
        {
            return node.Left()
                       .Accept(this)
                       .Concat(
                           node.Right()
                               .Accept(this)
                      ).ToList();
        }

        public override IList<Identifier> Visit(IUnary node) //Is this a hack?
        {
            return node.GetChildExpression().Accept(this);
        }

        public override IList<Identifier> Visit(Container node)
        {
            return new List<Identifier>();
        }

        public override IList<Identifier> Visit(Id node)
        {
            return new List<Identifier> { new Identifier(node, node.Identifier) };
        }
        

    }
}
