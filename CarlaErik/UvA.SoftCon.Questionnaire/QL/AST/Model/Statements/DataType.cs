using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
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
        String
    }
}
