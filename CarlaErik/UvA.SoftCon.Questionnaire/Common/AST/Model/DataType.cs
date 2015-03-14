using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common;

namespace UvA.SoftCon.Questionnaire.Common.AST.Model
{
    public enum DataType
    {
        [StringValue("undefined")]
        Undefined,
        [StringValue("bool")]
        Boolean,
        [StringValue("int")]
        Integer,
        [StringValue("string")]
        String,
        [StringValue("date")]
        Date,
    }
}
