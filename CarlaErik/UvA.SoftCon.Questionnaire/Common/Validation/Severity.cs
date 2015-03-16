using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;

namespace UvA.SoftCon.Questionnaire.Common.Validation
{
    public enum Severity
    {
        [StringValue("ERROR")]
        Error,
        [StringValue("WARN")]
        Warning
    }
}
