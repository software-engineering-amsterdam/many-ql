using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class Width : StyleAttribute
    {
        public int Value
        {
            get;
            private set;
        }

        internal Width(int value, TextPosition position)
            : base(position)
        {
            Value = value;
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitWidth(this);
        }
    }
}
