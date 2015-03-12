using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ITypeToValueVisitor
    {
        Values.String Visit(Types.StringType type);
        Values.Int Visit(Types.IntType type);
        Values.Bool Visit(Types.BoolType conditional);
    }
}
