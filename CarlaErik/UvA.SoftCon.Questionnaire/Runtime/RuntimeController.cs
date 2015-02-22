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
            var variableUsageVisitor = new VariableUsageCheckingVisitor();
            var typeCheckingVisitor = new TypeCheckingVisitor();
            var duplicateLabelVisitor = new DuplicateLabelCheckingVisitor();

            variableUsageVisitor.Visit(form);
            typeCheckingVisitor.Visit(form);
            duplicateLabelVisitor.Visit(form);

            var errorReport = new ErrorReportBuilder();

            errorReport.GenerateDuplicateLabelMessages(duplicateLabelVisitor);
            errorReport.GenerateTypeCheckingMessages(typeCheckingVisitor);
            errorReport.GenerateVariableUsageMessages(variableUsageVisitor);

            return errorReport;
        }
    }
}
