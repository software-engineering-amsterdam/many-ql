using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Building;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.Grammar;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Building
{
    internal class DefaultStyleBuilder : QLSBaseVisitor<DefaultStyle>
    {
        public override DefaultStyle VisitDefaultStyles(QLSParser.DefaultStylesContext context)
        {
            DataType dataType = StringEnum.GetEnumerationValue<DataType>(context.TYPE().GetText());
            var styleAttributes = new List<StyleAttribute>();

            foreach (var styleAttributeContext in context.style_attr())
            {
                styleAttributes.Add(styleAttributeContext.Accept(new StyleAttributeBuilder()));
            }

            return new DefaultStyle(dataType, styleAttributes, context.GetTextPosition());
        }
    }
}
