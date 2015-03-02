using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public enum Operation
    {
        [StringValue("+")]
        Add,
        [StringValue("&&")]
        And,
        [StringValue("/")]
        Divide,
        [StringValue("==")]
        EqualTo,
        [StringValue(">")]
        GreaterThan,
        [StringValue(">=")]
        GreaterThanOrEqualTo,
        [StringValue("<")]
        LessThan,
        [StringValue("<=")]
        LessThanOrEqualTo,
        [StringValue("*")]
        Multiply,
        [StringValue("!=")]
        NotEqualTo,
        [StringValue("||")]
        Or,
        [StringValue("-")]
        Substract,
        [StringValue("!")]
        Negation,
        [StringValue("++")]
        Increment
    }
}
