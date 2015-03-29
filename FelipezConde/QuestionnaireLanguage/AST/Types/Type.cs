using AST.Types.Visitors;

namespace AST.Types
{
    public abstract class Type : ITypeVisitable
    {
        public virtual bool IsInt()
        {
            return false;
        }

        public virtual bool IsBool()
        {
            return false;
        }

        public virtual bool IsString()
        {
            return false;
        }

        public virtual bool IsUndefined()
        {
            return false;
        }

        public abstract bool IsEqual(Type type);

        public abstract T Accept<T>(ITypeVisitor<T> visitor);

        public virtual Types.Type RetrieveType()
        {
            return new Types.UndefinedType();
        }
    }
}
