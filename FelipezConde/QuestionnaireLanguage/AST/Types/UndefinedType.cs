
namespace AST.Types
{
    public class UndefinedType : Type
    {
        public override bool IsEqual(Types.Type type)
        {
            return false;
        }

        public override bool IsUndefined()
        {
            return false;
        }

        public override T Accept<T>(Visitors.ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string ToString()
        {
            return "undefined";
        }
    }
}
