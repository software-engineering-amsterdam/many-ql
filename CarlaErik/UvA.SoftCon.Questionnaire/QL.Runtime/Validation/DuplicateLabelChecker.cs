using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Validation
{
    /// <summary>
    /// Checks for duplicate labels in questions.
    /// </summary>
    public class DuplicateLabelChecker : ASTChecker
    {
        private readonly ICollection<Question> _questions = new List<Question>();

        public override object Visit(BooleanQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(DateQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(IntegerQuestion question)
        {
            return VisitQuestion(question);
        }

        public override object Visit(StringQuestion question)
        {
            return VisitQuestion(question);
        }

        private object VisitQuestion(Question question)
        {
            if (LabelExists(question))
            {
                Report.AddWarning(question.Position, "Question '{0}' has a duplicate label.", question.Id.Name);
            }
            _questions.Add(question);
            return null;
        }

        private bool LabelExists(Question question)
        {
            return _questions.Any(q => q.Label == question.Label);
        }
    }
}
