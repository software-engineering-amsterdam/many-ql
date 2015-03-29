using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable boolean value.
    /// </summary>
    public class BooleanLiteral : Literal<bool>
    {
        private const string _true = "true";
        private const string _false = "false";

        public override bool IsValid
        {
            get
            {
                return Value.Equals(_true, StringComparison.OrdinalIgnoreCase)
                    || Value.Equals(_false, StringComparison.OrdinalIgnoreCase);
            }
        }

        internal BooleanLiteral(string value, TextPosition position)
            : base(value, position)
        {
        }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }

        public override bool GetValue()
        {
            if (IsValid)
            {
                return Value.Equals(_true, StringComparison.OrdinalIgnoreCase);
            }
            else
            {
                throw new InvalidOperationException("Cannot return the value of an invalid expressed boolean literal.");
            }
        }
    }
}
