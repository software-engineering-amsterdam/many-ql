using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Types
{
    public class BoolValue : Value<bool>
    {
        public BoolValue(bool value)
            : base(value) { }
    }
}
