using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public class BoolValue : Value<bool>
    {
        public BoolValue(bool value)
            : base(value) { }
    }
}
