using AST.Types.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

        public abstract void Accept(ITypeVisitor visitor);

        public abstract T Accept<T>(ITypeVisitor<T> visitor);

        public abstract string GetString();

        public virtual Types.Type RetrieveType()
        {
            return new Types.UndefinedType();
        }
    }
}
