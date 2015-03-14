using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.QLS
{
    /// <summary>
    /// Checks whether all questions are correctly referenced. That is; all questions of a QL are referenced exactly once by the QLS.
    /// </summary>
    internal class QuestionReferencingVisitor : QLSVisitor
    {
        internal QuestionReferencingVisitor(IEnumerable<Question> qlQuestions)
        {
        }

        public override void VisitQuestionReference(QuestionReference questionRef)
        {
        }
    }
}
