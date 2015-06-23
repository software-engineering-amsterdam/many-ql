using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class Section : QLSNode
    {
        public string Title
        {
            get;
            private set;
        }

        public IEnumerable<QuestionReference> QuestionReferences
        {
            get;
            private set;

        }
        public IEnumerable<DefaultStyle> DefaultStyles
        {
            get;
            private set;
        }

        internal Section(string title, IEnumerable<QuestionReference> questionReferences, IEnumerable<DefaultStyle> defaultStyles, TextPosition position)
            : base(position) 
        {
            Title = title;
            QuestionReferences = questionReferences;
            DefaultStyles = defaultStyles;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitSection(this);
        }
    }
}
