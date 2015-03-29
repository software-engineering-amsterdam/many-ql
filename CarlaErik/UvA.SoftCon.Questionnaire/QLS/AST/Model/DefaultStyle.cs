using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class DefaultStyle : QLSNode
    {
        public DataType DataType
        {
            get;
            private set;
        }

        public IEnumerable<StyleAttribute> StyleAttributes
        {
            get;
            private set;
        }

        internal DefaultStyle(DataType dataType, IEnumerable<StyleAttribute> styleAttributes, TextPosition position)
            : base(position)
        {
            DataType = dataType;
            StyleAttributes = styleAttributes;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitDefaultStyle(this);
        }
    }
}
