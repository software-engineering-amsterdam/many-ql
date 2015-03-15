using QuestionnaireLanguage.GUI.Widgets;
using QuestionnaireLanguage.Visitors.Interfaces;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToWidgetVisitor : ITypeToWidgetVisitor
    {
        private string id;
        public TypeToWidgetVisitor(string id)
        {
            this.id = id;
        }
        public Widget VisitValue(Types.Type value)
        {
            return Visit((dynamic)value);
        }
        public StringTextBoxWidget Visit(Types.StringType stringValue)
        {
            return new StringTextBoxWidget(id);
        }

        public IntegerTextBoxWidget Visit(Types.IntType intValue)
        {
            return new IntegerTextBoxWidget(id);
        }

        public CheckboxWidget Visit(Types.BoolType boolValue)
        {
            return new CheckboxWidget(id);
        }
    }
}
