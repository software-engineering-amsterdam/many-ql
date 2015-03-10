using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST.Types
{
    public class UndefinedType : Type
    {
        public override bool IsEqual(Types.Type type)
        {
            return type.IsUndefined();
        }

        public override bool IsUndefined()
        {
            return true;
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
            return "undefined";
        }
    }
}
