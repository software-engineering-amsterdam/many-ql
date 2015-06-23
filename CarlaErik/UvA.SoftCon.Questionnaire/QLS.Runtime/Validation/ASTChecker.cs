using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Validation
{
    internal abstract class ASTChecker : TopDownStyleSheetVisitor<object>
    {
        protected ValidationReport Report
        {
            get;
            set;
        }

        internal virtual void Validate(StyleSheet styleSheet, ValidationReport report)
        {
            Report = report;
            VisitStyleSheet(styleSheet);
        }
    }
}
