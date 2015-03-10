using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Types
{
    public class StringType : Type
    {
        public override bool IsString()
        {
            return false;
        }

        public override bool IsEqual(Type type)
        {
            return type.IsString();
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
            return "string";
        }
    }
}
