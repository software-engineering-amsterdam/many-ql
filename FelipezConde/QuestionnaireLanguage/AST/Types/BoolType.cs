
namespace AST.Types
{
    public class BoolType : Type
    {
        public override bool IsBool()
        {
            return true;
        }

        public override bool IsEqual(Type type)
        {
            return type.IsBool();
        }

        public override T Accept<T>(Visitors.ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "bool";
        }

        public override Types.Type RetrieveType()
        {
            return this;
        }
    }
}
