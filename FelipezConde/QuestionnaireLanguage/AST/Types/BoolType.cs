using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

        public override void Accept(Visitors.ITypeVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(Visitors.ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override string GetString()
        {
            return "bool";
        }

        public override Types.Type RetrieveType()
        {
            return this;
        }
    }
}
