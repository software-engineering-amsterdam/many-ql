using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Types.Visitors
{
    public interface ITypeVisitor<T>
    {
        T Visit(BoolType boolType);

        T Visit(IntType intType);

        T Visit(StringType stringType);

        T Visit(UndefinedType undefinedType);
    }
}
