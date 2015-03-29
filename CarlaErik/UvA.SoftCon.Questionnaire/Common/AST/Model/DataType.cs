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
