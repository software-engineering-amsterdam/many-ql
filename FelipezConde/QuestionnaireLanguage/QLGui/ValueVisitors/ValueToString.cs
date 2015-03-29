using Evaluation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QLGui.ValueVisitors
{
    public class ValueToString : IValueVisitor<string>
    {
        public string Visit(Evaluation.Values.String value)
        {
            return value.GetValue();
        }

        public string Visit(Evaluation.Values.Int value)
        {
            return value.GetValue().ToString();
        }

        public string Visit(Evaluation.Values.Bool value)
        {
            return value.GetValue().ToString();
        }
    }
}
