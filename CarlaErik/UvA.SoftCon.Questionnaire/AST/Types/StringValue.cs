using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Types
{
    public class StringValue : Value<string>
    {
        public StringValue(string value)
            : base(value) { }
    }
}
