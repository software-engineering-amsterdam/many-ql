using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Interfaces;
using AST.Representation;
using AST.Nodes.Values;
using Types = AST.Types;

namespace AST.Nodes.Expression
{
    public class Id : ASTNode, IExpression, IHasType
    {
        public string Identifier { get; private set; }
        
        public Id(string identifier, PositionInText position)
            : base(position)
        {
            this.Identifier = identifier;
        }

        public override void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string GetParsedString()
        {
            throw new NotImplementedException();
        }

        public Types.Type RetrieveType()
        {
            throw new NotImplementedException();
        }

        public void SetType()
        {
            throw new NotImplementedException();
        }
    }
}
