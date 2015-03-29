using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// A name that refers to a question in the QL AST.
    /// </summary>
    public class Identifier : QLSNode
    {
        public string Name
        {
            get;
            private set;
        }

        internal Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override T Accept<T>(IStyleSheetVisitor<T> visitor)
        {
            return visitor.VisitIdentifier(this);
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
