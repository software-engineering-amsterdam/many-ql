using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting
{
    public class ErrorReport
    {
        public ICollection<Message> Messages
        {
            get;
            private set;
        }

        public int NrOfWarnings
        {
            get
            {
                return Messages.Count(m => m.Severity == Severity.Warning);
            }
        }

        public int NrOfErrors
        {
            get
            {
                return Messages.Count(m => m.Severity == Severity.Error);
            }
        }

        public ErrorReport()
        {
            Messages = new List<Message>();
        }

        public void AddVariableUsageMessages(VariableUsageCheckingVisitor visitor)
        {
            foreach (var unusedVariable in visitor.UnusedVariables)
            {
                string message = String.Format("Variable '{0}' is declared but never used.", unusedVariable.Name);
                AddWarningMessage(message, unusedVariable.Position);
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

        public void AddDuplicateLabelMessages(DuplicateLabelCheckingVisitor visitor)
        {
            foreach (var duplicateLabel in visitor.DuplicateLabels)
            {
                string message = String.Format("Question '{0}' has a duplicate label.", duplicateLabel.Id.Name);

                AddWarningMessage(message, duplicateLabel.Position);
            }
        }

        public void AddLiteralCheckingMessages(LiteralCheckingVisitor visitor)
        {
            foreach (var literal in visitor.InvalidLiterals)
            {
                string message = String.Format("Invalid literal value '{0}' for type '{1}'.",
                    literal.Value, StringEnum.GetStringValue(literal.GetType(null)));

                AddErrorMessage(message, literal.Position);
            }
        }

        public void AddTypeCheckingMessages(TypeCheckingVisitor visitor)
        {
            foreach (var definition in visitor.InvalidDefinitions)
            {
                string message = String.Format("Cannot assign a value of type '{0}' to definition '{1}' of type '{2}'.",
                    StringEnum.GetStringValue(definition.ExpressionType), definition.Id.Name, StringEnum.GetStringValue(definition.TargetType));

                AddErrorMessage(message, definition.Id.Position);
            }

            foreach (var ifStatement in visitor.InvalidIfStatements)
            {
                string message = "Condition of if-statement is not a boolean expression.";

                AddErrorMessage(message, ifStatement.Position);
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

                AddErrorMessage(message, invalidExpression.Expression.Position);
            }
        }

        public string GetReport()
        {
            var report = new StringBuilder();

            foreach (var message in Messages.OrderBy(m => m.Position.Line))
            {
                report.AppendLine(message.ToString());
            }
            return report.ToString();
        }

        private void AddErrorMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Error, position, message));
        }

        private void AddWarningMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Warning, position, message));
        }
    }
}
