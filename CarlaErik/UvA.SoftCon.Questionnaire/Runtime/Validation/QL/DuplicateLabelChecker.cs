using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QL
{
    /// <summary>
    /// Checks for duplicate labels in questions.
    /// </summary>
    public class DuplicateLabelChecker : ASTChecker
    {
        private readonly ICollection<Question> _questions;

        public DuplicateLabelChecker()
        {
            _questions = new List<Question>();
        }

        public override object Visit(Question question)
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
