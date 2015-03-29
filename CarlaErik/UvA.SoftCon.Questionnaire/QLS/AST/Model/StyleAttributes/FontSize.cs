using System;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class FontSize : StyleAttribute
    {
        public int Size
        {
            get;
            private set;
        }

        internal FontSize(int size, TextPosition position)
            :base(position)
        {
            Size = size;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitFontSize(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideFontSize(Size);
        }

        public override string ToString()
        {
            return String.Format("{0}pt", Size);
        }
    }
}
