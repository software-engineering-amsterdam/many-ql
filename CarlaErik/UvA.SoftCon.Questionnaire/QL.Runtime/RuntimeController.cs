using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.QL.Runtime.Validation;

namespace UvA.SoftCon.Questionnaire.QL.Runtime
{
    public class RuntimeController
    {
        public ValidationReport Validate(QuestionForm form)
        {
            if (form == null) { throw new ArgumentNullException("form"); }

            var validators = new List<ASTChecker> 
            {
                new DuplicateLabelChecker(),
                new QuestionDeclarationChecker(),
                new TypeChecker(),
                new LiteralChecker(),
            };

            var report = new ValidationReport();

            foreach (var validator in validators)
            {
                validator.Validate(form, report);
            }

            return report;
        }

        public ValueTable Interpretet(QuestionForm form, ValueTable context)
        {
            if (form == null) { throw new ArgumentNullException("form"); }
            if (context == null) { throw new ArgumentNullException("context"); }

            var interpreter = new Interpreter();

            return interpreter.Interpretet(form, context);
        }
    }
}
