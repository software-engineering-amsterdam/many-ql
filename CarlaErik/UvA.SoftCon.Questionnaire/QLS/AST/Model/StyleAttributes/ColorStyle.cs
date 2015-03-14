using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class ColorStyle : StyleAttribute
    {
        public string RGBCode
        {
            get;
            private set;
        }

        internal ColorStyle(string rgbCode, TextPosition position)
            : base(position)
        {
            RGBCode = rgbCode;
        }

        public override void Accept(IQLSVisitor visitor)
        {
            visitor.VisitColorStyle(this);
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitColorStyle(this);
        }
    }
}
