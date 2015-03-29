using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Validation
{
    /// <summary>
    /// Checks whether style attributes have valid values.
    /// </summary>
    internal class StyleAttributeChecker : ASTChecker
    {
        public override object VisitFontSize(FontSize fontSize)
        {
            if (fontSize.Size <= 0)
            {
                Report.AddError(fontSize.Position, "Style attribute 'fontsize' must have a value greater than 0.");
            }
            return null;
        }
    }
}
