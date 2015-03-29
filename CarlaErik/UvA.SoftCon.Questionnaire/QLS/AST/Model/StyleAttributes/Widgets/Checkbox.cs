using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class CheckBox : Widget
    {
        internal CheckBox(TextPosition position)
            : base(position) { }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitCheckBox(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideWidget(new CheckBoxWidgetStyle());
        }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Boolean;
        }
    }
}
