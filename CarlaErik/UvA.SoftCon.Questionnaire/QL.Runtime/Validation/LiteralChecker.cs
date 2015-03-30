using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Validation
{
    /// <summary>
    /// Checks whether literal values are valid within the bounds of their types.
    /// </summary>
    public class LiteralChecker : ASTChecker
    {
        private const string InvalidLiteralMessage = "Invalid value '{0}' for literal of type '{1}'.";

        public override object Visit(IntegerLiteral literal)
        {
            if (!literal.IsValid)
            {
                Report.AddError(literal.Position, InvalidLiteralMessage, literal.Value, StringEnum.GetStringValue(literal.GetType(null)));
            }
            return null;
        }

        public override object Visit(DateLiteral literal)
        {
            if (!literal.IsValid)
            {
                Report.AddError(literal.Position, InvalidLiteralMessage, literal.Value, StringEnum.GetStringValue(literal.GetType(null)));
            }
            return null;
        }
    }
}
