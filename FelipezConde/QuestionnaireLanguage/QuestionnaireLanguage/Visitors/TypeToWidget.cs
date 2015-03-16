using QuestionnaireLanguage.GUI.FormObject;
using QuestionnaireLanguage.Visitors.Interfaces;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToWidget : ITypeVisitor<Widget>
    {
        private string id;
        public TypeToWidget(string id)
        {
            this.id = id;
        }
        public Widget VisitValue(Types.Type value)
        {
            return Visit((dynamic)value);
        }
        public Widget Visit(Types.StringType stringValue)
        {
            return new StringTextBoxWidget(id);
        }

        public Widget Visit(Types.IntType intValue)
        {
            return new IntTextBoxWidget(id);
        }

        public Widget Visit(Types.BoolType boolValue)
        {
            return new CheckboxWidget(id);
        }
    }
}
