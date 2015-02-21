using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.AST.Model.Statements
{
    public enum DataType
    {
        [StringValue("bool")]
        Boolean,
        [StringValue("double")]
        Double,
        [StringValue("int")]
        Integer,
        [StringValue("string")]
        String
    }
}
