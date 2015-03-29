using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public abstract class Statement : QLNode
    {
        protected Statement(TextPosition position)
            : base(position) { }

        internal abstract void CollectQuestions(ICollection<Question> questions);
    }
}
