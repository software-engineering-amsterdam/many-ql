using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Types.Visitors
{
    public interface ITypeVisitable
    {
        void Accept(ITypeVisitor visitor);
        T Accept<T>(ITypeVisitor<T> visitor);
    }
}
