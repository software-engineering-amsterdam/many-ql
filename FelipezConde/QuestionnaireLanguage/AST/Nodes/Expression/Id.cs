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
        public string Name { get; private set; }
        private Types.Type type = new Types.UndefinedType();
        
        public Id(string name, PositionInText position)
            : base(position)
        {
            this.Name = name;
        }

        public void Accept(Visitors.IVisitor visitor)
        {
            visitor.Visit(this);
        }

        public T Accept<T>(Visitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string GetParsedString()
        {
            throw new NotImplementedException();
        }

        public Types.Type RetrieveType()
        {
            return this.type;
        }

        public void SetType(Types.Type type)
        {
            this.type = type;
        }

        public override bool Equals(object obj)
        {
            return (this.Name == ((Id)obj).Name);
        }

        public override int GetHashCode()
        {
            return this.Name.GetHashCode();
        }
    }
}
