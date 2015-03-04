using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public class DateValue : Value<DateTime>
    {
        public override DataType DataType
        {
            get
            {
                return DataType.Date;
            }
        }

        public DateValue(DateTime value)
            : base(value) { }

    }
}
