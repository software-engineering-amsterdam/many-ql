using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.Validation;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation;
using UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types;
using UvA.SoftCon.Questionnaire.Runtime.Validation;
using UvA.SoftCon.Questionnaire.Runtime.Validation.QL;

namespace UvA.SoftCon.Questionnaire.Runtime
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

        public ValidationReport Validate(StyleSheet styleSheet, QuestionForm form)
        {
            if (styleSheet == null) { throw new ArgumentNullException("styleSheet"); }
            if (form == null) { throw new ArgumentNullException("form"); }

            var validators = new List<Validation.QLS.ASTChecker> 
            {
                new UvA.SoftCon.Questionnaire.Runtime.Validation.QLS.QuestionReferencingChecker(form.GetAllQuestions()),
                new UvA.SoftCon.Questionnaire.Runtime.Validation.QLS.StyleAttributeChecker(),
                new UvA.SoftCon.Questionnaire.Runtime.Validation.QLS.TypeChecker(form.GetAllQuestions())
            };

            var report = new ValidationReport();

            foreach (var validator in validators)
            {
                validator.Validate(styleSheet, report);
            }

            return report;
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
