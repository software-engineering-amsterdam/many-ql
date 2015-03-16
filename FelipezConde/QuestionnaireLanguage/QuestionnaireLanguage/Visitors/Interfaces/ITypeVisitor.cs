using QuestionnaireLanguage.GUI.FormObject;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ITypeVisitor<T>
    {
        T Visit(Types.StringType question);
        T Visit(Types.IntType conditional);
        T Visit(Types.BoolType conditional);
    }
}
