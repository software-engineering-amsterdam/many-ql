using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting
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

        internal ValidationReport()
        {
            Messages = new List<Message>();
        }

        internal void AddErrorMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Error, position, message));
        }

        internal void AddWarningMessage(string message, TextPosition position)
        {
            Messages.Add(new Message(Severity.Warning, position, message));
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
