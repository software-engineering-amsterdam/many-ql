using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;

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
