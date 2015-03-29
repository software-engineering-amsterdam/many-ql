using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class TextBox : Widget
    {
        internal TextBox(TextPosition position)
            : base(position) { }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitTextBox(this);
        }
        
        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.String || dataType == DataType.Integer;
        }
    }
}
