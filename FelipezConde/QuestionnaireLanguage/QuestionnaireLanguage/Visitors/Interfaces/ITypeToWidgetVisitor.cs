using QuestionnaireLanguage.GUI.Widgets;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors.Interfaces
{
    public interface ITypeToWidgetVisitor
    {
        StringTextBoxWidget Visit(Types.StringType question);
        IntegerTextBoxWidget Visit(Types.IntType conditional);
        CheckboxWidget Visit(Types.BoolType conditional);
    }
}
