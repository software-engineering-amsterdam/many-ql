using AST.Nodes.Interfaces;
using AST.Representation;

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

        public T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
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
            return (this.Name.Equals(((Id)obj).Name));
        }

        public override int GetHashCode()
        {
            return this.Name.GetHashCode();
        }
    }
}
