using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

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

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Boolean;
        }
    }
}
