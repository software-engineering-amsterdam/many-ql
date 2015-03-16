using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting;
using UvA.SoftCon.Questionnaire.Runtime.Validation.QL;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Validates a QL AST.
    /// </summary>
    internal class QLValidator
    {
        internal QLValidator() { }

        internal ValidationReport Validate(QuestionForm form)
        {
            var variableUsageVisitor = new VariableUsageChecker();
            var duplicateLabelVisitor = new DuplicateLabelChecker();
            var typeCheckingVisitor = new TypeChecker();
            var literalCheckingVisitor = new LiteralChecker();

            variableUsageVisitor.Visit(form);
            duplicateLabelVisitor.Visit(form);
            typeCheckingVisitor.Visit(form);
            literalCheckingVisitor.Visit(form);

            var report = new ValidationReport();

            AddVariableUsageMessages(variableUsageVisitor, report);
            AddDuplicateLabelMessages(duplicateLabelVisitor, report);
            AddTypeCheckingMessages(typeCheckingVisitor, report);
            AddLiteralCheckingMessages(literalCheckingVisitor, report);

            return report;
        }


        private void AddVariableUsageMessages(VariableUsageChecker visitor, ValidationReport report)
        {
            foreach (var unusedVariable in visitor.UnusedVariables)
            {
                string message = String.Format("Variable '{0}' is declared but never used.", unusedVariable.Name);
                report.AddWarningMessage(message, unusedVariable.Position);
            }

            foreach (var redeclaredVaribale in visitor.RedeclaredVariables)
            {
                string message = String.Format("Variable '{0}' is already defined.", redeclaredVaribale.Name);
                report.AddErrorMessage(message, redeclaredVaribale.Position);
            }

            foreach (var undeclaredVariable in visitor.UndeclaredVariables)
            {
                string message = String.Format("Variable '{0}' is not declared.", undeclaredVariable.Name);
                report.AddErrorMessage(message, undeclaredVariable.Position);
            }
        }

        private void AddDuplicateLabelMessages(DuplicateLabelChecker visitor, ValidationReport report)
        {
            foreach (var duplicateLabel in visitor.DuplicateLabels)
            {
                string message = String.Format("Question '{0}' has a duplicate label.", duplicateLabel.Id.Name);

                report.AddWarningMessage(message, duplicateLabel.Position);
            }
        }

        private void AddLiteralCheckingMessages(LiteralChecker visitor, ValidationReport report)
        {
            foreach (var literal in visitor.InvalidLiterals)
            {
                string message = String.Format("Invalid literal value '{0}' for type '{1}'.",
                    literal.Value, StringEnum.GetStringValue(literal.GetType(null)));

                report.AddErrorMessage(message, literal.Position);
            }
        }

        private void AddTypeCheckingMessages(TypeChecker visitor, ValidationReport report)
        {
            foreach (var definition in visitor.InvalidDefinitions)
            {
                string message = String.Format("Cannot assign a value of type '{0}' to definition '{1}' of type '{2}'.",
                    StringEnum.GetStringValue(definition.ExpressionType), definition.Id.Name, StringEnum.GetStringValue(definition.TargetType));

                report.AddErrorMessage(message, definition.Id.Position);
            }

            foreach (var ifStatement in visitor.InvalidIfStatements)
            {
                string message = "Condition of if-statement is not a boolean expression.";

                report.AddErrorMessage(message, ifStatement.Position);
            }

            foreach (var invalidExpression in visitor.InvalidUnaryExpressions)
            {
                string message = String.Format("Operator '{0}' can not be applied to operand of type '{1}'.",
                    StringEnum.GetStringValue(invalidExpression.Expression.Operation), StringEnum.GetStringValue(invalidExpression.OperandType));

            }

            foreach (var invalidExpression in visitor.InvalidBinaryExpressions)
            {
                string message = String.Format("Operator '{0}' can not be applied to operands of type '{1}' and '{2}'.",
                    StringEnum.GetStringValue(invalidExpression.Expression.Operation), StringEnum.GetStringValue(invalidExpression.LeftType), StringEnum.GetStringValue(invalidExpression.RightType));

                report.AddErrorMessage(message, invalidExpression.Expression.Position);
            }
        }
    }
}
