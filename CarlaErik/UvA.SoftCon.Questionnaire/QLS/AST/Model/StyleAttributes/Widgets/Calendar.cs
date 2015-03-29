using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class Calendar : Widget
    {
        internal Calendar(TextPosition position)
            : base(position) { }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitCalendar(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideWidget(new CalendarWidgetStyle());
        }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Date;
        }
    }
}
