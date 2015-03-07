using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable boolean value.
    /// </summary>
    public class BooleanLiteral : Literal<bool>
    {
        public BooleanLiteral(bool value, TextPosition position)
            : base(value, position)
        {
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }
    }
}
