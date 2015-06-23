using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public class QuestionReference : QLSNode
    {
        public Identifier Id
        {
            get;
            private set;
        }

        public IEnumerable<StyleAttribute> StyleAttributes
        {
            get;
            private set;
        }

        public string Name
        {
            get
            {
                return Id.Name;
            }
        }

        internal QuestionReference(Identifier id, IEnumerable<StyleAttribute> styleAttributes, TextPosition position)
            : base(position)
        {
            Id = id;
            StyleAttributes = styleAttributes;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitQuestionReference(this);
        }
    }
}
