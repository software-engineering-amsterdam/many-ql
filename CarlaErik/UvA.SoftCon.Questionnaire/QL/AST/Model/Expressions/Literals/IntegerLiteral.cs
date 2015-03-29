using System;
using System.Collections.Generic;
using System.Globalization;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable integer value.
    /// </summary>
    public class IntegerLiteral : Literal<int>
    {
        public override bool IsValid
        {
            get
            {
                int dummy;
                return Int32.TryParse(Value, NumberStyles.None, CultureInfo.InvariantCulture, out dummy);
            }
        }

        internal IntegerLiteral(string value, TextPosition position)
            : base(value, position) { }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }

        public override int GetValue()
        {
            if (IsValid)
            {
                return Int32.Parse(Value, CultureInfo.InvariantCulture);
            }
            else
            {
                throw new InvalidOperationException("Cannot return the value of an invalid expressed integer literal.");
            }
        }
    }
}
