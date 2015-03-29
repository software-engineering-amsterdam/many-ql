using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    public abstract class QLSNode : Node
    {
        protected QLSNode(TextPosition position)
            : base(position)
        {
        }

        public abstract T Accept<T>(IStyleSheetVisitor<T> visitor);
    }
}
