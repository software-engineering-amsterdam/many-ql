using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation.ErrorReporting
{
    public enum Severity
    {
        [StringValue("ERROR")]
        Error,
        [StringValue("WARN")]
        Warning
    }
}
