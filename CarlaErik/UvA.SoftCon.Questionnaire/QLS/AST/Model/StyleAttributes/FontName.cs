using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.StyleSets;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes
{
    public class FontName : StyleAttribute
    {
        public string Name
        {
            get;
            private set;
        }

        internal FontName(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitFontName(this);
        }

        public override void OverrideStyle(StyleSet styleSet)
        {
            styleSet.OverrideFontName(Name);
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
