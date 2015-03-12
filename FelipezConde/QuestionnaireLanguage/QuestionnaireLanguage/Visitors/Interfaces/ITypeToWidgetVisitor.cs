using QuestionnaireLanguage.GUI.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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
