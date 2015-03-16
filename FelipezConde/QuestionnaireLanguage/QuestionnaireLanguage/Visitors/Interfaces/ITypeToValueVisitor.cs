using Types = AST.Types;
using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ITypeToValueVisitor
    {
        Values.String Visit(Types.StringType type);
        Values.Int Visit(Types.IntType type);
        Values.Bool Visit(Types.BoolType conditional);
    }
}
