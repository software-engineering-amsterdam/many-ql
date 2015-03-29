using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Statements
{
    public class IntegerQuestion : Question
    {
        internal IntegerQuestion(Identifier id, string label, Expression expression, TextPosition position)
            : base(DataType.Integer, id, label, expression, position) { }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
