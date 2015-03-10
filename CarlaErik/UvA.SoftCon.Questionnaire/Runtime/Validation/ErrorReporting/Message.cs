using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.Utilities;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting
{
    public class Message
    {
        public Severity Severity
        {
            get;
            private set;
        }

        public TextPosition Position
        {
            get;
            private set;
        }

        public string Text
        {
            get;
            private set;
        }

        public Message(Severity severity, TextPosition position, string text)
        {
            Severity = severity;
            Position = position;
            Text = text;
        }

        public override string ToString()
        {
            return String.Format("{0,-5} - {1} Line: {2}, column: {3}", StringEnum.GetStringValue(Severity), Text, Position.Line, Position.Column);
        }
    }
}
