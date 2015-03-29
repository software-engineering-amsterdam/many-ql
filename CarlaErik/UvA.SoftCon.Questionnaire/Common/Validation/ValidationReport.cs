using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.Common.Validation
{
    public class ValidationReport
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

        public int NrOfMessages
        {
            get
            {
                return Messages.Count();
            }
        }

        public ValidationReport()
        {
            Messages = new List<Message>();
        }

        public void AddWarning(TextPosition position, string message)
        {
            Messages.Add(new Message(Severity.Warning, position, message));
        }

        public void AddWarning(TextPosition position, string message, params object[] args)
        {
            AddWarning(position, String.Format(message, args));
        }

        public void AddError(TextPosition position, string message)
        {
            Messages.Add(new Message(Severity.Error, position, message));
        }

        public void AddError(TextPosition position, string message, params object[] args)
        {
            AddError(position, String.Format(message, args));
        }

        public override string ToString()
        {
            var report = new StringBuilder();

            foreach (var message in Messages.OrderBy(m => m.Position.Line))
            {
                report.AppendLine(message.ToString());
            }
            return report.ToString();
        }
    }
}
