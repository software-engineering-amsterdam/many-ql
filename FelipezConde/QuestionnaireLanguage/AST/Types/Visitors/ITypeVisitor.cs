using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Types.Visitors
{
    public interface ITypeVisitor
    {
        void Visit(BoolType boolType);

        void Visit(IntType intType);

        void Visit(StringType stringType);

        void Visit(UndefinedType undefinedType);
    }
}
