using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class Calendar : Widget
    {
        internal Calendar(TextPosition position)
            : base(position) { }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Date;
        }
    }
}
