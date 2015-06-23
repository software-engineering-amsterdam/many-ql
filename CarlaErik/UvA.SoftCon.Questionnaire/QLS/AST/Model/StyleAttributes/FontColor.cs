using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class FontColor : StyleAttribute
    {
        public string RGBCode
        {
            get;
            private set;
        }

        internal FontColor(string rgbCode, TextPosition position)
            : base(position)
        {
            RGBCode = rgbCode;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitFontColor(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideFontColor(RGBCode);
        }

        public override string ToString()
        {
            return RGBCode;
        }
    }
}
