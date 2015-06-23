using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Page : QLSNode
    {
        public Identifier Id
        {
            get;
            private set;
        }

        public IEnumerable<Section> Sections
        {
            get;
            private set;
        }

        public IEnumerable<DefaultStyle> DefaultStyles
        {
            get;
            private set;
        }

        internal Page(Identifier id, IEnumerable<Section> sections, IEnumerable<DefaultStyle> defaultStyles, TextPosition position)
            : base(position)
        {
            Id = id;
            Sections = sections;
            DefaultStyles = defaultStyles;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitPage(this);
        }
    }
}
