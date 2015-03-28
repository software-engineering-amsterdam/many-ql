
namespace AST.Types
{
    public class IntType : Type
    {
        public override bool IsInt()
        {
            return true;
        }

        public override bool IsEqual(Type type)
        {
            return type.IsInt();
        }

        public override T Accept<T>(Visitors.ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "int";
        }
    }
}
