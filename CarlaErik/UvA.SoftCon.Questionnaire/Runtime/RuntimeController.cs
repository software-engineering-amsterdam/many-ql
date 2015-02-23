using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime
{
    public class RuntimeController
    {
        public ErrorReportBuilder Validate(Form form)
        {
            if (form == null) { throw new ArgumentNullException("form"); }

            var variableUsageVisitor = new VariableUsageCheckingVisitor();
            var duplicateLabelVisitor = new DuplicateLabelCheckingVisitor();
            var typeCheckingVisitor = new TypeCheckingVisitor();

            variableUsageVisitor.Visit(form);
            //duplicateLabelVisitor.Visit(form);
            typeCheckingVisitor.Visit(form);

            var errorReport = new ErrorReportBuilder();

            errorReport.GenerateVariableUsageMessages(variableUsageVisitor);
            errorReport.GenerateDuplicateLabelMessages(duplicateLabelVisitor);
            errorReport.GenerateTypeCheckingMessages(typeCheckingVisitor);

            return errorReport;
        }
    }
}
