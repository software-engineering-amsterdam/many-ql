using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;

namespace UvA.SoftCon.Questionnaire.Runtime
{
    public class RuntimeController
    {
        public ErrorReport Validate(QuestionForm form)
        {
            if (form == null) { throw new ArgumentNullException("form"); }

            var variableUsageVisitor = new VariableUsageCheckingVisitor();
            var duplicateLabelVisitor = new DuplicateLabelCheckingVisitor();
            var typeCheckingVisitor = new TypeCheckingVisitor();

            variableUsageVisitor.Visit(form);
            duplicateLabelVisitor.Visit(form);
            typeCheckingVisitor.Visit(form);

            var errorReport = new ErrorReport();

            errorReport.AddVariableUsageMessages(variableUsageVisitor);
            errorReport.AddDuplicateLabelMessages(duplicateLabelVisitor);
            errorReport.AddTypeCheckingMessages(typeCheckingVisitor);

            return errorReport;
        }

        public IDictionary<string, Value> Interpretet(QuestionForm form, IDictionary<string, Value> context)
        {
            if (form == null) { throw new ArgumentNullException("form"); }
            if (context == null) { throw new ArgumentNullException("context"); }

            var interpreter = new Interpreter();

            interpreter.Interpretet(form, context);

            return interpreter.AvailableQuestions;
        }
    }
}
