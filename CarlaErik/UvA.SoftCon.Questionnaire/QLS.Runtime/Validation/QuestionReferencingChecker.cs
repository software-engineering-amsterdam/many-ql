using System.Collections.Generic;
using System.Linq;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Validation
{
    /// <summary>
    /// Checks whether all questions are correctly referenced. That is; all questions of a QL are referenced exactly once by the QLS.
    /// </summary>
    internal class QuestionReferencingChecker : ASTChecker
    {
        private ICollection<string> _unrefferedQuestions = new List<string>();
        private ICollection<string> _referredQuestions = new List<string>();

        internal QuestionReferencingChecker(IEnumerable<Question> qlQuestions)
        {
            // A question can be defined multiple times in the QL. We only need it once.
            _unrefferedQuestions = qlQuestions.Select(q => q.Name).Distinct().ToList();
        }

        internal override void Validate(StyleSheet styleSheet, ValidationReport report)
        {
            base.Validate(styleSheet, report);

            foreach (var unrefferedQuestion in _unrefferedQuestions)
            {
                Report.AddError(TextPosition.None, "The QL question '{0}' is not referred in the QLS.", unrefferedQuestion);
            }
        }

        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            if (_unrefferedQuestions.Contains(questionRef.Name))
            {
                _unrefferedQuestions.Remove(questionRef.Name);
                _referredQuestions.Add(questionRef.Name);
            }
            else
            {
                if (_referredQuestions.Contains(questionRef.Name))
                {
                    Report.AddError(questionRef.Position, "The style sheet already contains a reference to question '{0}'.", questionRef.Name);
                }
                else
                {
                    Report.AddError(questionRef.Position, "Question '{0}' is not defined in the QL.", questionRef.Name);
                }
            }
            return null;
        }
    }
}
