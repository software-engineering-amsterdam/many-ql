using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public class Integer : Numeric<int>
    {
        public override IValue Add(IValue value)
        {
            Value + ((Integer)value).Value;
        }
    }
}
