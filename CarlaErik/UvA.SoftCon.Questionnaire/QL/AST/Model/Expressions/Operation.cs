using UvA.SoftCon.Questionnaire.Common;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions
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
