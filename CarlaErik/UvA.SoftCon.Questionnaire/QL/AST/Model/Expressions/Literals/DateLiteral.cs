using System;
using System.Collections.Generic;
using System.Globalization;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    public class DateLiteral : Literal<DateTime>
    {
        private const string _dateFormat = "d-M-yyyy";
        private const string _today = "today";
        private const string _yesterday = "yesterday";
        private const string _tomorrow = "tomorrow";

        public override bool IsValid
        {
            get
            {
                DateTime date = DateTime.MinValue;

                return (Value.Equals(_today, StringComparison.OrdinalIgnoreCase)
                    || Value.Equals(_yesterday, StringComparison.OrdinalIgnoreCase)
                    || Value.Equals(_tomorrow, StringComparison.OrdinalIgnoreCase)
                    || DateTime.TryParseExact(Value, "d-M-yyyy", CultureInfo.InvariantCulture, DateTimeStyles.None, out date));
            }
        }

        internal DateLiteral(string dateString, TextPosition position)
            : base(dateString, position)
        {
        }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Date;
        }

        public override DateTime GetValue()
        {
            if (IsValid)
            {
                if (Value.Equals(_today, StringComparison.OrdinalIgnoreCase))
                {
                    return DateTime.Today;
                }
                else if (Value.Equals(_yesterday, StringComparison.OrdinalIgnoreCase))
                {
                    return DateTime.Today.AddDays(-1);
                }
                else if (Value.Equals(_tomorrow, StringComparison.OrdinalIgnoreCase))
                {
                    return DateTime.Today.AddDays(1);
                }
                else
                {
                    return DateTime.ParseExact(Value, "d-M-yyyy", CultureInfo.InvariantCulture);
                }
            }
            else
            {
                throw new InvalidOperationException("Cannot return the value of an invalid expressed date literal.");
            }
        }
    }
}
