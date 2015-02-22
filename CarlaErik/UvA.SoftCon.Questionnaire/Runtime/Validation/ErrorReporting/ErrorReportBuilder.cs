using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting
{
    public class ErrorReportBuilder
    {
        public ICollection<Message> Messages
        {
            get;
            private set;
        }

        public ErrorReportBuilder()
        {
            Messages = new List<Message>();
        }

        public void GenerateVariableUsageMessages(VariableUsageCheckingVisitor visitor) 
        {
            foreach (var declaredVaribale in visitor.DeclaredVariables.Values)
            {
                if (declaredVaribale.UsageCount == 0)
                {
                    string message = String.Format("Variable '{0}' is declared but never used.", declaredVaribale.Identifier.Name);
                    AddWarningMessage(message, declaredVaribale.Identifier.Position);
                }
            }

            foreach (var redeclaredVaribale in visitor.RedeclaredVariables)
            {
                string message = String.Format("Variable '{0}' is already defined.", redeclaredVaribale.Name);

                AddErrorMessage(message, redeclaredVaribale.Position);
            }

            foreach (var undeclaredVariable in visitor.UndeclaredVariables)
            {
                string message = String.Format("Variable '{0}' is not declared.", undeclaredVariable.Name);

                AddErrorMessage(message, undeclaredVariable.Position);
            }
        }

        public void GenerateDuplicateLabelMessages(DuplicateLabelCheckingVisitor visitor)
        {
            foreach (var duplicateLabel in visitor.DuplicateLabels)
            {
                string message = String.Format("Question '{0}' has a duplicate label.", duplicateLabel.Id.Name);

                AddWarningMessage(message, duplicateLabel.Position);
            }
        }

        public void GenerateTypeCheckingMessages(TypeCheckingVisitor visitor)
        {
            foreach (var assignment in visitor.InvalidAssignments)
            {
                string message = String.Format("Cannot assign a value of type '{0}' to variable '{1}' of type '{2}'.",
                    StringEnum.GetStringValue(assignment.ExpressionType), assignment.Id.Name, StringEnum.GetStringValue(assignment.TargetType));

                AddErrorMessage(message, assignment.Id.Position);
            }

            foreach (var ifStatement in visitor.InvalidIfStatements)
            {
                string message = "Condition of if-statement is not a boolean expression.";

                AddErrorMessage(message, ifStatement.Position);
            }

            foreach (var invalidExpression in visitor.InvalidBinaryExpressions)
            {
                string message = String.Format("Operator '{0}' can not be applied to operands of type '{1}' and '{2}'.",
                    StringEnum.GetStringValue(invalidExpression.Expression.Operation), StringEnum.GetStringValue(invalidExpression.LeftType), StringEnum.GetStringValue(invalidExpression.RightType));

                AddErrorMessage(message, invalidExpression.Expression.Position);
            }
        }

        private void AddErrorMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Error, position, message));
        }

        private void AddWarningMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Warning, position, message));
        }

        public string GetReport()
        {
            var report = new StringBuilder();

            foreach (var message in Messages)
            {
                report.AppendLine(message.ToString());
            }
            return report.ToString();
        }
    }
}
