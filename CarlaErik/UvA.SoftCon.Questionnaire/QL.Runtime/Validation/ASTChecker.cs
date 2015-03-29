using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Validation
{
    public abstract class ASTChecker : TopDownQuestionFormVisitor<object>
    {
        protected ValidationReport Report 
        {
            get;
            set;
        }

        public void Validate(QuestionForm form, ValidationReport report)
        {
            Report = report;
            Visit(form);
        }
    }
}
