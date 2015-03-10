using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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
            return "int";
        }
    }
}
