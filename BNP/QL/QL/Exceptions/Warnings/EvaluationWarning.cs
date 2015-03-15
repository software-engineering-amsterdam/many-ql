using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QL.Exceptions
{
    public class EvaluationWarning : QLWarning
    {
        public override string Origin
        {
            get { return "Evaluation warning"; }
        }
    }
}
