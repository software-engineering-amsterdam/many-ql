using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Validation
{
    /// <summary>
    /// Checks whether all questions are correctly referenced. That is; all questions of a QL are referenced exactly once by the QLS.
    /// </summary>
    internal class QuestionReferencingChecker : ASTChecker
    {
        private ICollection<string> unrefferedQuestions = new List<string>();
        private ICollection<string> referredQuestions = new List<string>();

        internal QuestionReferencingChecker(IEnumerable<Question> qlQuestions)
        {
            // A question can be defined multiple times in the QL. We only need it once.
            unrefferedQuestions = qlQuestions.Select(q => q.Name).Distinct().ToList();
        }

        public override void Validate(StyleSheet styleSheet, ValidationReport report)
        {
            base.Validate(styleSheet, report);

            foreach (var unrefferedQuestion in unrefferedQuestions)
            {
                Report.AddError(TextPosition.None, "The QL question '{0}' is not referred in the QLS.", unrefferedQuestion);
            }
        }

        public override object VisitQuestionReference(QuestionReference questionRef)
        {
            if (unrefferedQuestions.Contains(questionRef.Name))
            {
                unrefferedQuestions.Remove(questionRef.Name);
                referredQuestions.Add(questionRef.Name);
            }
            else
            {
                if (referredQuestions.Contains(questionRef.Name))
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
