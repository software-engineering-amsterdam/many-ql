using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Parsing
{
    public class ShortToUnicodeString : QLBaseListener
    {
        private StringBuilder _result = new StringBuilder();

        public override void EnterInit(QLParser.InitContext context)
        {
            _result.Append('"');
        }

        public override void ExitInit(QLParser.InitContext context)
        {
            _result.Append('"');
        }

        public override void EnterValue(QLParser.ValueContext context)
        {
            int value = Int32.Parse(context.INT().GetText());
            _result.AppendFormat(@"\u{0:X04}", value);
        }

        public string GetResult()
        {
            return _result.ToString();
        }
    }
}
